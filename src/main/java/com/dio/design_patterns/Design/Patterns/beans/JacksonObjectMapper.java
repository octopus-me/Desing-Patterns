package com.dio.design_patterns.Design.Patterns.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonObjectMapper {

    @Bean
    public com.fasterxml.jackson.databind.ObjectMapper getMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }
}
