package com.pack.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "REST-API-01")
public interface FeignClientClass 
{
	@GetMapping(value = "/welcome/welcome")
	public String message();
}
