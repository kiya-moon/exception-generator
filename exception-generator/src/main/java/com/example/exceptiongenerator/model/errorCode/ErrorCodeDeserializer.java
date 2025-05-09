package com.example.exceptiongenerator.model.errorCode;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ErrorCodeDeserializer extends StdDeserializer<ErrorCode> {

    public ErrorCodeDeserializer() {
        super(ErrorCode.class);
    }

    @Override
    public ErrorCode deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        int code = p.getIntValue();
        return ErrorCode.fromCode(code);
    }
}
