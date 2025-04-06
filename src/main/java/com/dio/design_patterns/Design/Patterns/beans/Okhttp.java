package com.dio.design_patterns.Design.Patterns.beans;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Okhttp {

    OkHttpClient client = new OkHttpClient();

    @Bean
    public OkHttpClient getClient(){
        return this.client;
    }
}
