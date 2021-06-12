package com.jigowatts.faq.application.component;

import com.jigowatts.faq.domain.model.order.OrderNumber;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderNumberPublisherImpl implements OrderNumberPublisher {
    private final DateTimeResolver dateTimeResolver;
    private final UniqueIdGenerator uniqueIdGenerator;

    @Override
    public OrderNumber publish() {
        var today = dateTimeResolver.getCurrentDate();
        String uniqueId = uniqueIdGenerator.generate();

        return new OrderNumber(today, uniqueId);
    }
}
