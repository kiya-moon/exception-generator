package com.example.exceptiongenerator.generator;

import com.example.exceptiongenerator.model.ExceptionSpec;
import com.example.exceptiongenerator.model.errorCode.ErrorCode;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ExceptionClassGenerator {

    public void generate(ExceptionSpec spec) {
        String className = spec.getExceptionName();
        String errorMessage = spec.getErrorMessage();
        ErrorCode errorCode = spec.getErrorCode();

        String source = String.format("""
        package com.example.exceptiongenerator.exception;

        public class %s extends RuntimeException {
            private final ErrorCode errorCode;

            public %s(String errorMessage, ErrorCode errorCode) {
                super(errorMessage);
                this.errorCode = errorCode;
            }

            public String getErrorMessage() {
                return "%s";
            }

            public ErrorCode getErrorCode() {
                return errorCode;
            }
        }
        """, className, className, errorMessage, errorCode);

        try {
            Path filePath = Paths.get("src/main/java/com/example/exceptiongenerator/exception/" + className + ".java");
            Files.createDirectories(filePath.getParent());
            Files.writeString(filePath, source, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("예외 클래스 파일 생성 실패", e);
        }
    }
}

