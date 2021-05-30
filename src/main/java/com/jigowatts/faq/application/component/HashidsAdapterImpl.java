package com.jigowatts.faq.application.component;

import org.hashids.Hashids;
import org.springframework.stereotype.Component;

@Component
public class HashidsAdapterImpl implements HashidsAdapter {
    private static final String SALT = "my salt";
    private static final int MAX_LENGTH = 8;

    private final Hashids hashids;

    public HashidsAdapterImpl() {
        this.hashids = new Hashids(SALT, MAX_LENGTH);
    }

    @Override
    public String encode(int seedId) {
        return hashids.encode(seedId);
    }
}
