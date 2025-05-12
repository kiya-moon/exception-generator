package com.example.exceptiongenerator.model;

import com.example.exceptiongenerator.model.errorCode.ErrorCode;
import com.example.exceptiongenerator.model.errorCode.ErrorCodeDeserializer;
import com.example.exceptiongenerator.model.errorCode.ErrorCodeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class ExceptionSpec {
    private String exceptionName;
    private String errorMessage;
    @JsonDeserialize(using = ErrorCodeDeserializer.class)
    @JsonSerialize(using = ErrorCodeSerializer.class)
    private ErrorCode errorCode;
}
