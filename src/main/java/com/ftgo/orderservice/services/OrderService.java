package com.ftgo.orderservice.services;

import com.ftgo.orderservice.aggregrates.Order;
import io.reactivex.Flowable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public Flowable<Order> createOrder(Order order) {
        return Flowable.just(order);
    }

    public Flowable<Order> updateOrder(Order order) {
        return Flowable.just(order);
    }

    public Flowable<Order> cancelOrder(Order order) {
        return Flowable.just(order);
    }

    public Flowable<Order> reviseOrder(Order order) {
        return Flowable.just(order);
    }

    public Flowable<Order> getOrder(int orderId) {
        return Flowable.just(new Order());
    }

    public Flowable<List<Order>> getOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());
        orders.add(new Order());
        return Flowable.just(orders);
    }
}
