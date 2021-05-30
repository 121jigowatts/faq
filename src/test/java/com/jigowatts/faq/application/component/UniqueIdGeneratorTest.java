package com.jigowatts.faq.application.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import com.jigowatts.faq.domain.model.order.Seed;
import com.jigowatts.faq.infrastructure.mapper.SeedsMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UniqueIdGeneratorTest {
    @Mock
    private DateTimeResolver dateTimeResolver;
    @Mock
    private SeedsMapper seedsMapper;
    @Mock
    private HashidsAdapter hashidsGenerator;
    @InjectMocks
    private UniqueIdGeneratorImpl target;

    @Test
    @DisplayName("ユニークIDの生成")
    void generate() {
        var now = LocalDateTime.of(2021, 2, 3, 12, 34, 56, 789);

        doReturn(now).when(dateTimeResolver).getCurrentDateTime();
        var seed = Seed.builder().usedAt(now).build();
        doReturn(1).when(seedsMapper).insert(seed);

        doReturn("A1b2c3D4").when(hashidsGenerator).encode(anyInt());
        String actual = target.generate();

        assertEquals(8, actual.length());
        assertEquals("A1b2c3D4", actual);
        verify(dateTimeResolver, times(1)).getCurrentDateTime();
        verify(seedsMapper, times(1)).insert(seed);
        verify(hashidsGenerator, times(1)).encode(anyInt());
    }
}
