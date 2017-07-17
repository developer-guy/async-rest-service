package com.bthnapaydin.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.AsyncRestTemplate;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class AsynchronousSpringServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsynchronousSpringServiceApplication.class, args);
    }

    @Bean
    public AsyncRestTemplate asyncRestTemplate() {
        return new AsyncRestTemplate();
    }
}
