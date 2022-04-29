package com.customerdetails.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.customerdetails.model.Customers;
import com.customerdetails.repository.CustomerRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customers customer = customerRepository.findByUsername(username);
        if(customer != null) {
            GrantedAuthority authority = new SimpleGrantedAuthority(customer.getRole());
            return new User(customer.getUsername(), customer.getPassword(),Arrays.asList(authority));
        }
        else return new User(null,null,null);
    }
}

