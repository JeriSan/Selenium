package com.comsatel.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties
@Getter
@Setter
public class AppProperties {
	private String browser;
    private String baseUrl;
    private int timeout;
}
