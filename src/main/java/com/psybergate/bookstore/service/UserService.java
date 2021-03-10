package com.psybergate.bookstore.service;

import com.psybergate.bookstore.domain.User;

public interface UserService {

    User createUser(User user);

    User findByid(Long id);

    User findByEmail(String email);

}
