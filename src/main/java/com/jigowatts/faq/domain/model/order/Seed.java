package com.jigowatts.faq.domain.model.order;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seed {
    private int id;
    private LocalDateTime usedAt;
}
