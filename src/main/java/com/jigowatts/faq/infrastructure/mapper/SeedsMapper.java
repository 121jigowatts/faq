package com.jigowatts.faq.infrastructure.mapper;

import java.util.List;

import com.jigowatts.faq.domain.model.order.Seed;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SeedsMapper {
    @Select("SELECT id, used_at as usedAt FROM seeds ORDER BY id")
    List<Seed> selectAll();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO seeds (used_at) VALUES (#{usedAt})")
    int insert(Seed seed);
}
