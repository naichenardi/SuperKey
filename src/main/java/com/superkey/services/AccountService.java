package com.superkey.services;

import com.superkey.db.entities.Account;
import com.superkey.db.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll() {
        Iterable<Account> accounts = accountRepository.findAll();
        List<Account> list = new ArrayList<>();
        accounts.iterator().forEachRemaining(list::add);
        return list;
    }
}
