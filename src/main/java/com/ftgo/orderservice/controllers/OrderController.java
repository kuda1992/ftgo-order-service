package com.ftgo.orderservice.controllers;

import com.ftgo.orderservice.aggregrates.Order;
import com.ftgo.orderservice.services.OrderService;
import io.reactivex.Flowable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;


    @GetMapping({"/", ""})
    public ResponseEntity<Flowable<List<Order>>> getOrders() {
        return ResponseEntity.ok(this.orderService.getOrders());
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Flowable<Order>> getOrder(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.orderService.getOrder(id));
    }


    @PostMapping("/create")
    public Flowable<Order> createOrder(@Valid @RequestBody Order order) {
        return this.orderService.createOrder(order);
    }

}
