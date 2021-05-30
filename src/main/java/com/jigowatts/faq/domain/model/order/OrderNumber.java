package com.jigowatts.faq.domain.model.order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class OrderNumber {
    private static final int SPECIFIED_LENGTH = 8;
    private static final String DATE_FORMAT = "yyyyMMdd";
    private static final String REGEX_HALF_WIDTH_ALPHANUMERIC_CHARACTERS = "^[A-Za-z0-9]+$";
    private final LocalDate today;
    private final String uniqueId;

    public OrderNumber(LocalDate today, String uniqueId) {
        if (null == today) {
            throw new IllegalArgumentException("today is null.");
        }
        if (!StringUtils.hasText(uniqueId)) {
            throw new IllegalArgumentException("uniqueId has not text.");
        }
        if (uniqueId.length() != SPECIFIED_LENGTH) {
            throw new IllegalArgumentException("uniqueId is not a 8-digit string.");
        }
        if (!(isHalfWidthAlphanumericCharacters(uniqueId))) {
            throw new IllegalArgumentException("uniqueId is not half width alphanumeric characters.");
        }

        this.today = today;
        this.uniqueId = uniqueId;
    }

    private boolean isHalfWidthAlphanumericCharacters(String target) {
        var pattern = Pattern.compile(REGEX_HALF_WIDTH_ALPHANUMERIC_CHARACTERS);
        var matcher = pattern.matcher(target);
        return matcher.matches();
    }

    @Override
    public String toString() {
        var dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return today.format(dateTimeFormatter) + uniqueId;
    }
}
