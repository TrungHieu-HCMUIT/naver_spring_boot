package com.example.naver.spring.boot.api.computer.service.model.computer_factory;

import com.example.naver.spring.boot.api.computer.service.model.Computer;

// We use this to implement more type of ComputerFactory in the future
public abstract class BaseComputerFactory {
    public abstract Computer getComputer(String type) throws Exception;
}
