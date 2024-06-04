package com.xion.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskSchedulerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskSchedulerService.class);

    // Task1 - runs every 10Sec.
//    @Async("asyncTaskExecutor")
    @Scheduled(fixedRate = 10000)
    public void executeTask1() {
        LOGGER.info("Task1 completed.");
    }

    // Task2 - runs every 2 minutes for 1 minute.
//    @Async("asyncTaskExecutor")
    @Scheduled(fixedRate = 120000)
    public void executeTask2() throws InterruptedException {
        int count = 0;
        while(count < 6) {
            LOGGER.info("Task2 is running.");
            Thread.sleep(10000);
            count++;
        }
        LOGGER.info("Task2 completed.");
    }
}
