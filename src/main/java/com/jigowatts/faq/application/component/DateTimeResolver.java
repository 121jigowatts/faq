package com.jigowatts.faq.application.component;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DateTimeResolver {
    LocalDate getCurrentDate();
    LocalDateTime getCurrentDateTime();
}
