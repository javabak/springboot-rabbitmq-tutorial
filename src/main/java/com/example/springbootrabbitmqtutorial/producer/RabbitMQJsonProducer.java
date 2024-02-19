package com.example.springbootrabbitmqtutorial.producer;

import com.example.springbootrabbitmqtutorial.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonProducer {


    @Value("${rabbit.exchange.json.name}")
    private String exchange_json;

    @Value("${rabbit.routing.json.key}")
    private String routing_json;


    private final RabbitTemplate template;

    @Autowired
    public RabbitMQJsonProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void sendJsonMessage(User user) {
        log.info("Json message sent: " + user.toString());
        template.convertAndSend(exchange_json, routing_json, user);
    }
}
