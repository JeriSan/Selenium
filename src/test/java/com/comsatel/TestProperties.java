package com.comsatel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comsatel.util.AppConfig;
import com.comsatel.util.AppProperties;

public class TestProperties {
	@Test
    public void testAppProperties() {
        // Configura el contexto de Spring manualmente
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        context.refresh();

        // Obtén el bean de AppProperties
        AppProperties appProperties = context.getBean(AppProperties.class);
        System.out.println("url: "+appProperties.getBaseUrl());
        System.out.println("browser: "+appProperties.getBrowser());
        System.out.println("timeout: "+appProperties.getTimeout());
        // Verifica las propiedades
        assertEquals("chrome", appProperties.getBrowser());
        assertEquals("https://www.example.com", appProperties.getBaseUrl());
        assertEquals(5, appProperties.getTimeout());
        
        context.close();
    }
}