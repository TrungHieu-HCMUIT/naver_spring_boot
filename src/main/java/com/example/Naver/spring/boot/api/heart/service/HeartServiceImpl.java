package com.example.naver.spring.boot.api.heart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HeartServiceImpl implements HeartService {

    @Override
    public void printLog() {
        // do nothing
        // this function is used to log before and after calling
    }
}
