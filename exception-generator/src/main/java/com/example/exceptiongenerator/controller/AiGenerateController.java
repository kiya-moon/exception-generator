package com.example.exceptiongenerator.controller;

import com.example.exceptiongenerator.generator.ExceptionClassGenerator;
import com.example.exceptiongenerator.model.ExceptionSpec;
import com.example.exceptiongenerator.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/generate")
@RequiredArgsConstructor
public class AiGenerateController {

    private final OpenAiService openAiService;
    private final ExceptionClassGenerator exceptionClassGenerator;

    @PostMapping("/ai")
    public ResponseEntity<String> generateFromPrompt(@RequestBody String prompt) {
        ExceptionSpec spec = openAiService.ask(prompt);
        exceptionClassGenerator.generate(spec);
        return ResponseEntity.ok("예외 클래스 생성 완료: " + spec.getExceptionName());
    }
}