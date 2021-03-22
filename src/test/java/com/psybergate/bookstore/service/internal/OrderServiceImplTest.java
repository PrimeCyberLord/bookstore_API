package com.psybergate.bookstore.service.internal;

import com.psybergate.bookstore.domain.Book;
import com.psybergate.bookstore.domain.Order;
import com.psybergate.bookstore.repository.OrderRepository;
import com.psybergate.bookstore.repository.UserRepository;
import com.psybergate.bookstore.service.OrderService;
import com.psybergate.bookstore.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class OrderServiceImplTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderService orderService;


    @TestConfiguration
    static class ConfigureTestClasses {
        @Bean
        public OrderService orderService(OrderRepository orderRepository, UserService userService) {
            return new OrderServiceImpl(orderRepository, userService);
        }

        @Bean
        public UserService userService(UserRepository userRepository) {
            return new UserServiceImpl(userRepository);
        }

    }

    @Test
    @WithMockUser("john@gmail.com")
    public void createValidOrderWithUser() {
        Order actual = new Order();
        actual.setBooks(createOrderBooks());
        Order expected = orderService.createOrder(actual);
        assertEquals(expected, actual);
    }

   /* @Test
    public void createValidOrderWithoutUser() {
        Order actual = new Order();
        actual.setBooks(createOrderBooks());
        Order expected = orderService.createOrder(actual);
    }*/

    @Test
    @WithMockUser("john@gmail.com")
    public void findAllOrders() {
        Order order = new Order();
        order.setBooks(createOrderBooks());
        orderService.createOrder(order);
        int actualSize = 1;
        int expectedSize = orderService.findAllOrders().size();
        assertEquals(expectedSize, actualSize);
    }

    private List<Book> createOrderBooks() {
        List<Book> books = new ArrayList<>();
        books.add(createBook("isbn1", 2, 200));
        books.add(createBook("isbn2", 4, 200));
        books.add(createBook("isbn3", 6, 200));
        return books;
    }

    private Book createBook(String isbn, int quantity, double price) {
        Book book = new Book();
        book.setISBN(isbn);
        book.setQuantity(quantity);
        book.setPrice(price);
        return book;
    }

}
