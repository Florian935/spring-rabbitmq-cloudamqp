package com.florian935.cloudampq.controller;

import com.florian935.cloudampq.domain.Order;
import com.florian935.cloudampq.producer.Producer;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1.0/orders")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderController {

    Producer<Order> orderProducer;

    @PostMapping(path = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public Order orderBook(@RequestBody Order order) {

        order.setId(UUID.randomUUID().toString());
        orderProducer.produce(order);

        return order;
    }
}
