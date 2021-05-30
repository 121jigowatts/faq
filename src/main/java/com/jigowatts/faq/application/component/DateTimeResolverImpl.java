package com.jigowatts.faq.application.component;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class DateTimeResolverImpl implements DateTimeResolver {

    @Override
    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    @Override
    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
    
}
