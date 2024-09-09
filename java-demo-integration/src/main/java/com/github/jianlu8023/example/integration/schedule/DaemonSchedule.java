package com.github.jianlu8023.example.integration.schedule;

import org.slf4j.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

@Component
public class DaemonSchedule {
    private static final Logger L = LoggerFactory.getLogger(DaemonSchedule.class);

    @Scheduled(cron = "*/15 * * * * *")
    public void daemon() {
        L.debug("service daemon ...");
    }
}
