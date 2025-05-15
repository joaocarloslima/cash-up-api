package br.com.fiap.cash_up_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class PromptConfig {
    
    @Bean
    Resource systemMessage(){
        return new ClassPathResource("system.st");
    }
    
}
