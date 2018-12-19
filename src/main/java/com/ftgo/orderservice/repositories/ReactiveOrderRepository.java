package com.ftgo.orderservice.repositories;

import com.ftgo.orderservice.aggregrates.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveOrderRepository extends ReactiveCrudRepository<Order, String> {
}
