package com.example.naver.spring.boot.api.computer.service;

import com.example.naver.spring.boot.api.computer.service.model.Computer;
import com.example.naver.spring.boot.api.computer.service.model.ComputerType;
import com.example.naver.spring.boot.api.computer.service.model.computer_factory.ComputerFactory;
import com.example.naver.spring.boot.common.error_handling.custom_exception.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FactoryMethodService {

    @Autowired
    ComputerFactory computerFactory;

    public Map<String, String> getComputerFromValue(String type) {

        Computer computer = computerFactory.getComputer(type);
        if (computer == null) {
            throw new InvalidRequestException();
        }

        String valueFromComputer = computer.getType();
        Map<String, String> response = new HashMap<>();
        response.put("type", type);
        response.put("computer", valueFromComputer);

        return response;
    }
}
