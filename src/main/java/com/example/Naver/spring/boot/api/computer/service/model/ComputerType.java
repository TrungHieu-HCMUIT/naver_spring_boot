package com.example.naver.spring.boot.api.computer.service.model;

import com.example.naver.spring.boot.common.error_handling.custom_exception.InvalidRequestException;

public enum ComputerType {
    PC("pc"),
    SERVER("server");

    public final String typeValue;

    ComputerType(String typeValue) {
        this.typeValue = typeValue;
    }

    public static ComputerType fromString(String value) {
        for (ComputerType type: values()) {
            if (type.typeValue.equals(value))
                return type;
        }
        return null;
    }
}
