package com.optivem.kata.banking.infra.real;

import com.optivem.kata.banking.core.ports.driven.DateTimeServicePort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SysDateTimeService implements DateTimeServicePort {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
