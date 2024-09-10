package com.pack.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.pack.entity.Address;

@Configuration
public class RedisConfigurations 
{
	@Bean
	public JedisConnectionFactory jedisConnection()
	{
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Address> redisTemplate(JedisConnectionFactory connectionFactory)
	{
		RedisTemplate<String, Address> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}
}
