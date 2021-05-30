package com.jigowatts.faq.application.service;

import com.jigowatts.faq.application.component.DateTimeResolver;
import com.jigowatts.faq.application.component.UniqueIdGenerator;
import com.jigowatts.faq.domain.model.order.OrderNumber;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdsServiceImpl implements IdsService {
    private final DateTimeResolver dateTimeResolver;
    private final UniqueIdGenerator uniqueIdGenerator;

    @Override
    public OrderNumber generate() {
        var today = dateTimeResolver.getCurrentDate();
        String uniqueId = uniqueIdGenerator.generate();

        return new OrderNumber(today, uniqueId);
    }
}
