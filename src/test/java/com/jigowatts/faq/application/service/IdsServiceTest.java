package com.jigowatts.faq.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import com.jigowatts.faq.application.component.OrderNumberPublisher;
import com.jigowatts.faq.domain.model.order.OrderNumber;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdsServiceTest {
    @Mock
    OrderNumberPublisher orderNumberPublisher;
    @InjectMocks
    IdsServiceImpl target;

    @Test
    void test_publish() {
        doReturn(new OrderNumber(LocalDate.of(2021, 2, 3), "A1b2c3D4")).when(orderNumberPublisher).publish();

        OrderNumber actual = target.publish();

        verify(orderNumberPublisher, times(1)).publish();
        assertEquals("20210203A1b2c3D4", actual.toString());
    }
}
