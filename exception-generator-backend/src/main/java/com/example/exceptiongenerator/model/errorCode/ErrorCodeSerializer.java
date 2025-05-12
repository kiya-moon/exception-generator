package com.example.exceptiongenerator.model.errorCode;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ErrorCodeSerializer extends StdSerializer<ErrorCode> {

    public ErrorCodeSerializer() {
        super(ErrorCode.class);
    }

    @Override
    public void serialize(ErrorCode value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(value.getCode());
    }
}
