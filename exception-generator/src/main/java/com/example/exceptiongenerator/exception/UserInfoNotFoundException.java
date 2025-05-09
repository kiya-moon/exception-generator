package com.example.exceptiongenerator.exception;

import com.example.exceptiongenerator.model.errorCode.ErrorCode;

public class UserInfoNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public UserInfoNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return "유저 정보를 찾을 수 없습니다.";
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
