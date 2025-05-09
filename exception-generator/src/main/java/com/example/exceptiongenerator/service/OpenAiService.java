package com.example.exceptiongenerator.service;

import com.example.exceptiongenerator.model.ExceptionSpec;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OpenAiService {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private final RestTemplate restTemplate;

    public ExceptionSpec ask(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(openAiApiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                )
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        Map<?, ?> response = restTemplate.postForObject(
                "https://api.openai.com/v1/chat/completions",
                request,
                Map.class
        );

        // 응답 디버깅 로그 추가
        System.out.println("OpenAI API Response: " + response);

        String content = (String) ((Map<?, ?>)((Map<?, ?>)((List<?>)response.get("choices")).get(0)).get("message")).get("content");

        // content가 JSON 문자열인지 확인
        System.out.println("Content: " + content);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // JSON 문자열을 Java 객체로 변환
            return objectMapper.readValue(content, ExceptionSpec.class);
        } catch (Exception e) {
            throw new RuntimeException("AI 응답 파싱 실패: " + content, e);
        }
    }
}