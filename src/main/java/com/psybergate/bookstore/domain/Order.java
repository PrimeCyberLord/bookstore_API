package com.psybergate.bookstore.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "order")
public class Order extends BaseEntity {

    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    private double totalPrice;

    private String address;

    private LocalDate dateCreated;

}
