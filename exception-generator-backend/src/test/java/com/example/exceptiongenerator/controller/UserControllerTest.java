package com.example.exceptiongenerator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void 사용자_정보가_없을_때_예외_반환() throws Exception {
        mockMvc.perform(get("/user/0"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorMessage").value("유저 정보를 찾을 수 없습니다."))
                .andExpect(jsonPath("$.errorCode").value(404));
    }

    @Test
    void 사용자_정보가_있을_때_정상_응답() throws Exception {
        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("유저 정보: 유저 ID = 2"));
    }
}