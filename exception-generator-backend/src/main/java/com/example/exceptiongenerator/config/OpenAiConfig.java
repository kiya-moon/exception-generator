package com.example.exceptiongenerator.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component // 또는 @EnableConfigurationProperties를 사용할 수도 있음
@ConfigurationProperties(prefix = "openai")
public class OpenAiConfig {
    private String apiKey;
    private String model;
}