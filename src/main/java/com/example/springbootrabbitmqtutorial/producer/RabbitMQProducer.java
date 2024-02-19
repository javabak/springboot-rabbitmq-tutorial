package com.example.springbootrabbitmqtutorial.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQProducer {

    @Value("${rabbit.exchange.name}")
    private String exchange;

    @Value("${rabbit.routing.ket")
    private String routing;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        log.info("Message sent: " + message);
        rabbitTemplate.convertAndSend(exchange, routing, message);
    }
}
