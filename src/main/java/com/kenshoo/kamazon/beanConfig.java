package com.kenshoo.kamazon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class beanConfig {

    @Bean
    public HashUtils hashUtils() throws Exception {
        return new HashUtils();
    }

}
