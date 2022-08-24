package com.example.naver.spring.boot.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
    public ResponseEntity<Object> successResponse(Object data) {
        Map<String, Object> body = new HashMap<>();
        body.put("data", data);
        body.put("statusCode", HttpStatus.OK.value());
        return ResponseEntity.ok(body);
    }
}
