package com.sisipapa.study.docker.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("p8081")
@WebMvcTest
class CommonControllerTest {

//    @Autowired
//    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

//    @BeforeEach
//    void beforeEach() {
//        mockMvc = MockMvcBuilders
//                .webAppContextSetup(wac)
//                .alwaysDo(print())
//                .build();
//    }

    @Test
    void port() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("8081"));
    }
}