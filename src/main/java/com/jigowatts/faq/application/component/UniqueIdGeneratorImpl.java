package com.jigowatts.faq.application.component;

import com.jigowatts.faq.domain.model.order.Seed;
import com.jigowatts.faq.infrastructure.mapper.SeedsMapper;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UniqueIdGeneratorImpl implements UniqueIdGenerator {
    private final SeedsMapper seedsMapper;
    private final DateTimeResolver dateTimeResolver;
    private final HashidsAdapter hashidsAdapter;

    @Override
    @Transactional
    public String generate() {
        var seed = Seed.builder().usedAt(dateTimeResolver.getCurrentDateTime()).build();
        seedsMapper.insert(seed);
        return hashidsAdapter.encode(seed.getId());
    }
}
