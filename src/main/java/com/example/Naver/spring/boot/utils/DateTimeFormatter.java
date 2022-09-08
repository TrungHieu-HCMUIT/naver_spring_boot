package com.example.naver.spring.boot.utils;

import com.example.naver.spring.boot.aspect.error_handling.custom_exception.InvalidRequestException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormatter {
    private static final String DD_MM_YYYY = "dd-MM-yyyy";

    public static Date stringToDate(String source) {
        SimpleDateFormat formatter = new SimpleDateFormat(DD_MM_YYYY);
        try {
            return formatter.parse(source);
        } catch (ParseException e) {
            throw new InvalidRequestException();
        }
    }
}
