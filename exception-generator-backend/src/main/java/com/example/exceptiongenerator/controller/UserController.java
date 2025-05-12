package com.example.exceptiongenerator.controller;

import com.example.exceptiongenerator.exception.UserInfoNotFoundException;
import com.example.exceptiongenerator.model.errorCode.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/{id}")
    public ResponseEntity<String> getUserById(@PathVariable String id) {
        if (id.equals("0")) {
            throw new UserInfoNotFoundException(ErrorCode.USER_NOT_FOUND);
        }
        return ResponseEntity.ok("User found: " + id);
    }
}
