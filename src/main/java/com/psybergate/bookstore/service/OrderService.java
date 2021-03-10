package com.psybergate.bookstore.service;

import com.psybergate.bookstore.domain.Order;

import java.util.List;

public interface OrderService {

    Order findOrderById(Long id);

    List<Order> findAllOrders();

}
