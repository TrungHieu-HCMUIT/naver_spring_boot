package com.example.naver.spring.boot.api.product.model;

public enum ConditionType {
    GREATER_THAN("greater_than"),
    LESS_THAN("less_than"),
    EQUAL("equal");

    public final String condition;

    ConditionType(String condition) {
        this.condition = condition;
    }

    public static ConditionType fromString(String value) {
        for (ConditionType type : values()) {
            if (type.condition.equals(value))
                return type;
        }
        return null;
    }

}
