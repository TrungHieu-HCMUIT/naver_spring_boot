package com.example.naver.spring.boot.api.computer.service.model.computer_factory;

import com.example.naver.spring.boot.api.computer.service.model.Computer;

public abstract class BaseComputerFactory {
    public abstract Computer getComputer(String type) throws Exception;
}
