package com.florian935.cloudampq.producer;

public interface Producer<T> {

    void produce(T message);
}
