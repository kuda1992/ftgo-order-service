package com.ftgo.orderservice.services;

import com.ftgo.orderservice.aggregrates.Order;
import com.ftgo.orderservice.repositories.ReactiveOrderRepository;
import com.ftgo.orderservice.sagas.CreateOrderSaga;
import io.reactivex.Flowable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private ReactiveOrderRepository reactiveOrderRepository;

    @Autowired
    private CreateOrderSaga createOrderSaga;

    public Mono<Order> createOrder(Order order) {
        return reactiveOrderRepository.save(order);
    }

    public Flowable<Order> updateOrder(Order order) {
        return Flowable.just(order);
    }

    public Flowable<Order> approveOrder(Order order) {
        return Flowable.just(order);
    }

    public Flowable<Order> cancelOrder(Order order) {
        return Flowable.just(order);
    }

    public Flowable<Order> reviseOrder(Order order) {
        return Flowable.just(order);
    }

    public Mono<Order> getOrder(String orderId) {
        return this.reactiveOrderRepository.findById(orderId);
    }

    public Flux<Order> getOrders() {
        return this.reactiveOrderRepository.findAll();
    }
}
