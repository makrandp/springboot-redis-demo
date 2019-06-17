package com.example.springbootredisapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;

@RestController
public class RedisController {
	
	@Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private int redisPort;
	
	@GetMapping("/")
	public String index() 
	{
		return "Index Route - visit /get route";
	}
	
	@GetMapping("/get")
	public String getAllTodos() 
	{
		Jedis jedis = new Jedis(this.redisHost, this.redisPort);
		jedis.set("key", "value");
		return jedis.get("key");
	}
	
}
