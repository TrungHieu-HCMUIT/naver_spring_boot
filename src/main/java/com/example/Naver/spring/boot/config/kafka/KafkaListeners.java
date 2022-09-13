package com.example.naver.spring.boot.config.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "likelion",
            groupId = "groupId"
    )
    void listener(String data) {
        System.out.printf("Kafka listener received: %s\n", data);
    }
}
