package com.springrestjsonapi.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableMongoAuditing
public class UserConfig {




    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
