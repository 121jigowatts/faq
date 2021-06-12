package com.jigowatts.faq.application.service;

import com.jigowatts.faq.application.component.OrderNumberPublisher;
import com.jigowatts.faq.domain.model.order.OrderNumber;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdsServiceImpl implements IdsService {
    private final OrderNumberPublisher orderNumberPublisher;

    @Override
    public OrderNumber publish() {
        return orderNumberPublisher.publish();
    }
}
