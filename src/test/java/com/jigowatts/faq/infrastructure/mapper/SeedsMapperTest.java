package com.jigowatts.faq.infrastructure.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import java.time.LocalDateTime;
import java.util.List;

import com.jigowatts.faq.domain.model.order.Seed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@MybatisTest
class SeedsMapperTest {
    @Autowired
    private SeedsMapper target;

    @BeforeEach
    @Sql(scripts = "/data/mapper/SeedsMapperTest/base.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    void setup() {

    }

    @Test
    @DisplayName("select")
    void select() {
        List<Seed> actual = target.selectAll();

        assertEquals(1, actual.size());
    }

    @Test
    @DisplayName("insert")
    void insert() {
        var seed = Seed.builder().usedAt(LocalDateTime.of(2021, 02, 03, 12, 34, 56, 789)).build();

        var actual = target.insert(seed);
        assertEquals(1, actual);
        assertEquals(2, seed.getId());
    }
}
