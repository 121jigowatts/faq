package com.jigowatts.faq.application.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import com.jigowatts.faq.domain.model.order.OrderNumber;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderNumberPublisherTest {
    @Mock
    DateTimeResolver dateTimeResolver;
    @Mock
    UniqueIdGenerator uniqueIdGenerator;
    @InjectMocks
    OrderNumberPublisherImpl target;

    @Test
    void test_publish() {
        doReturn(LocalDate.of(2021, 2, 3)).when(dateTimeResolver).getCurrentDate();
        doReturn("A1b2c3D4").when(uniqueIdGenerator).generate();
        OrderNumber actual = target.publish();

        verify(dateTimeResolver, times(1)).getCurrentDate();
        verify(uniqueIdGenerator, times(1)).generate();
        assertEquals("20210203A1b2c3D4", actual.toString());
    }
}
