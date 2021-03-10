package com.psybergate.bookstore.web.controller.rest;


import com.psybergate.bookstore.domain.Order;
import com.psybergate.bookstore.service.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Order> getAllOrders(){
        return orderService.findAllOrders();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Order getOrder(@PathVariable("id") Long orderId){
        return orderService.findOrderById(orderId);
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public List<Order> createOrder(@RequestBody Order order){
        orderService.createOrder(order);
        return orderService.findAllOrders();
    }




}
