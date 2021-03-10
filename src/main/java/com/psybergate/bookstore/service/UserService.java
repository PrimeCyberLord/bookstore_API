package com.psybergate.bookstore.service;

import com.psybergate.bookstore.domain.User;

public interface UserService {

    User findByid(Long id);

    User findByEmail(String email);

}
