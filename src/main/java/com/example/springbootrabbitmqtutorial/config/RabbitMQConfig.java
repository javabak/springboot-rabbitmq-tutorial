package com.example.springbootrabbitmqtutorial.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.messaging.Message;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbit.queue.name}")
    private String queue;

    @Value("${rabbit.exchange.name}")
    private String exchange;

    @Value("${rabbit.routing.key}")
    private String routing;


    @Value("${rabbit.queue.json.name}")
    private String queue_json;

    @Value("${rabbit.exchange.json.name}")
    private String exchange_json;

    @Value("${rabbit.routing.json.key}")
    private String routing_json;

    @Bean
    public Queue queue() {
        return new Queue(queue);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routing);
    }

    @Bean
    public Queue queueJson() {
        return new Queue(queue_json);
    }

    @Bean
    public TopicExchange exchangeJson() {
        return new TopicExchange(exchange_json);
    }

    @Bean
    public Binding bindingJson() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routing_json);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
