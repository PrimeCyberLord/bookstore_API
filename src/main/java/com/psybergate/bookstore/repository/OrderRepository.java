package com.psybergate.bookstore.repository;

import com.psybergate.bookstore.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
