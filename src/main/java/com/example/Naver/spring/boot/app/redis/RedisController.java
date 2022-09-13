package com.example.naver.spring.boot.app.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping("redis/{message}")
    public void publish(@PathVariable("message") String message) {
        redisTemplate.opsForValue().set("likelion", message);
        System.out.printf("Redis listener received: %s\n", redisTemplate.opsForValue().get("likelion"));
    }
}
