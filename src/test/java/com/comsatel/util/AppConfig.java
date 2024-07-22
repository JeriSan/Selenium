package com.comsatel.util;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties(AppProperties.class)
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
        ClassPathResource resource = new ClassPathResource("application.properties");
        if (resource.exists()) {
            System.out.println("application.properties found.");
        } else {
            System.out.println("application.properties not found.");
        }
        properties.setLocation(resource);
        return properties;
    }
}
