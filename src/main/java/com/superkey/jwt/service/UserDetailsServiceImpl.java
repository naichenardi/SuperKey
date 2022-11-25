package com.superkey.jwt.service;

import com.superkey.db.entities.Account;
import com.superkey.db.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final AccountRepository repository;

    public UserDetailsServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Account account = repository.findByEmail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + mail));

        return UserDetailsImpl.build(account);
    }
}
