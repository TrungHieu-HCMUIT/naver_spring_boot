package com.example.naver.spring.boot.api.computer.service.model.computer_factory;

import com.example.naver.spring.boot.api.computer.service.model.Computer;
import com.example.naver.spring.boot.api.computer.service.model.ComputerType;
import com.example.naver.spring.boot.api.computer.service.model.PC;
import com.example.naver.spring.boot.api.computer.service.model.Server;
import org.springframework.stereotype.Component;

@Component
public class ComputerFactory extends BaseComputerFactory {

    @Override
    public Computer getComputer(String type) {
        ComputerType computerType = ComputerType.fromString(type.toLowerCase());
        if (computerType == null) return null;

        switch (computerType) {
            case PC:
                return new PC();
            case SERVER:
                return new Server();
            default:
                return null;
        }
    }
}
