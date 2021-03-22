package com.psybergate.bookstore.service.internal;

import com.psybergate.bookstore.domain.User;
import com.psybergate.bookstore.repository.UserRepository;
import com.psybergate.bookstore.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private TestEntityManager testEntityManager;

    @TestConfiguration
    static class configureTestClasses {

        @Bean
        public UserService userService(UserRepository userRepository) {
            return new UserServiceImpl(userRepository);
        }
    }

    @Test
    public void findUserByValidEmailReturnsUser() {
        User expected = userService.findByEmail("john@gmail.com");
        assertNotNull(expected);
    }

    @Test
    public void findUserByInvalidEmailReturnsNull() {
        User expected = userService.findByEmail("email@gmail.com");
        assertNull(expected);
    }

    @BeforeEach
    public void init() {
        testEntityManager.persist(createUser());
    }

    private User createUser() {
        User user = new User();
        user.setEmail("john@gmail.com");
        user.setName("john");
        user.setSurname("doe");
        return user;
    }

}
