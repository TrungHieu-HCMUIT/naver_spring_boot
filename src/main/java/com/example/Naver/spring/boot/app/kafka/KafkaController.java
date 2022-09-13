package com.example.naver.spring.boot.app.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("kafka/{message}")
    public void publish(@PathVariable("message") String message) {
        kafkaTemplate.send("likelion", message);
    }
}
