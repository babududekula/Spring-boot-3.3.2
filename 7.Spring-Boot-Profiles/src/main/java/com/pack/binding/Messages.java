package com.pack.binding;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data 
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "babu")
public class Messages 
{
	private Map<String, String> map = new HashMap<>();
}
