package com.springai.scholarmind.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.chat.client.ChatClient;

@Configuration
public class AppConfig {

    @Bean
    public ChatClient.Builder chatClientBuilder() {
        return ChatClient.builder();
    }
}
