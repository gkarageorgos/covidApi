package com.unipi.postgraduate_jkarageorgos.covidapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")//epitrepei na xtipisoume to endpoint apo opoidipote url
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")//epitrpomenes methodoi gia ola tA URL MAS
                        .allowedHeaders("*");//epitrepei opoiodipote header
            }
        };
    }
}
