package com.example.exceptiongenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ExceptionGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionGeneratorApplication.class, args);
	}

	// 외부 API에 HTTP 요청을 보내기 위해 사용
	// Spring Boot에서는 기본적으로 RestTemplate을 자동 생성하지 않기 때문에, 직접 Bean으로 등록해야 한다
	@Bean
	public RestTemplate restTemplate() { return new RestTemplate(); }

}
