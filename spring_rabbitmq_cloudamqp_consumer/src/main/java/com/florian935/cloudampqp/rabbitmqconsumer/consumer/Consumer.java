package com.florian935.cloudampqp.rabbitmqconsumer.consumer;

public interface Consumer<T> {

    void consume(T message);
}
