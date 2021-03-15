package com.psybergate.bookstore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book extends BaseEntity {

    private String ISBN;

    private double price;

    private int quantity;

}
