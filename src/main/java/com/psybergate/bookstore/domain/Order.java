package com.psybergate.bookstore.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "app_order")
public class Order extends BaseEntity {

    @ManyToOne
    private User owner;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books;

    private double totalPrice;

    private String address;

    private LocalDate dateCreated;

    public void init() {
        totalPrice = calcTotalPrice(books);
        dateCreated = LocalDate.now();
    }

    private double calcTotalPrice(List<Book> books) {

        double total = 0;

        for (Book book : books) {
            total += book.getPrice() * book.getQuantity();
        }

        return total;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(this.getClass() == o.getClass())) return false;
        Order order = (Order) o;
        if (!(this.getId() == order.getId())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

}
