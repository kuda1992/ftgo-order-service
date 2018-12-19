package com.ftgo.orderservice.controllers;

import com.ftgo.orderservice.aggregrates.Order;
import com.ftgo.orderservice.services.OrderService;
import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/orders")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;


    @GetMapping({"/", ""})
    public ResponseEntity<Flux<Order>> getOrders() {
        LOGGER.info("get all orders");
        return ResponseEntity.ok(this.orderService.getOrders());
    }

    @GetMapping({"/{orderId}", "/{orderId}/"})
    public ResponseEntity<Mono<Order>> getOrder(@PathVariable("orderId") String orderId) {
        LOGGER.info("get order by orderId " + orderId);
        return ResponseEntity.ok(this.orderService.getOrder(orderId));
    }

    @PostMapping("/create")
    public  Mono<Order> createOrder(@Valid @RequestBody Order order) {
        return this.orderService.createOrder(order);
    }

}
