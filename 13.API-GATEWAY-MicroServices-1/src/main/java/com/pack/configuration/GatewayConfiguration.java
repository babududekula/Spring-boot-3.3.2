package com.pack.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration 
{
	@Bean
	public RouteLocator customLocator(RouteLocatorBuilder builder)
	{
		return builder.routes()
				.route(r->r.path("/welcome").uri("lb://REST-API-01"))
				.route(r->r.path("/wish/{name}").uri("lb://REST-API-02"))
				.build();
				
	}
}
