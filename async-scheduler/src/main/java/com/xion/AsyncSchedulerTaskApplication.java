package com.xion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AsyncSchedulerTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncSchedulerTaskApplication.class);
    }
}
