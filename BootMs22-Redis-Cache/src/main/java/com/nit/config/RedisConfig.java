package com.nit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.nit.model.User;

@Configuration
public class RedisConfig {
	
	//1) JedisConnectionFactory (to establish the connection)
	@Bean
	public JedisConnectionFactory jcf() {
		JedisConnectionFactory jcf=new JedisConnectionFactory();
		return jcf;
	}//jcf
	
	//2) RedisTemplate<String,User>    (to use redis )
	@Bean
	public RedisTemplate<String,User> redisTemplate(){
		RedisTemplate<String,User> template=new RedisTemplate<>();
		//create template using jcf
		template.setConnectionFactory(jcf());
		return template;
	}//redisTemplate
}
