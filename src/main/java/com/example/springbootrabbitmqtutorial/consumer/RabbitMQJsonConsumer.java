package com.example.springbootrabbitmqtutorial.consumer;

import com.example.springbootrabbitmqtutorial.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbit.queue.json.name}"})
    public void consumeJson(User user) {
        log.info("Json message received: " + user.toString());
    }
}
