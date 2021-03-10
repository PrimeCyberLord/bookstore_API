package com.psybergate.bookstore.service.internal;

import com.psybergate.bookstore.domain.Role;
import com.psybergate.bookstore.domain.User;
import com.psybergate.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if(user==null) throw new UsernameNotFoundException("user associated with "+ email + " does not exist");

        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(User user){
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for(Role role: user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().getDescription()));
        }

        return grantedAuthorities;
    }


}