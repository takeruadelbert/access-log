package com.stn.logging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class LoggingApplication {
    @Value("${queue.access-log.name}")
    private String queueName;

    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }
}
