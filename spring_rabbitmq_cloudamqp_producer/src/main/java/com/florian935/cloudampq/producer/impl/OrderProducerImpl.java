package com.florian935.cloudampq.producer.impl;

import com.florian935.cloudampq.config.MessagingProperties;
import com.florian935.cloudampq.domain.Order;
import com.florian935.cloudampq.producer.Producer;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderProducerImpl implements Producer<Order> {

    RabbitTemplate customRabbitTemplate;
    MessagingProperties messagingProperties;

    @Override
    public void produce(Order order) {

            customRabbitTemplate.convertAndSend(
                    messagingProperties.getExchangeName(), messagingProperties.getRoutingKey(), order);
    }
}
