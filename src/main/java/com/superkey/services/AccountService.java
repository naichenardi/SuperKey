package com.superkey.services;

import com.superkey.controllers.dto.AccountDTO;
import com.superkey.db.entities.Account;
import com.superkey.db.repositories.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;


    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Page<AccountDTO> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable).map(Account::toDTO);
    }

    public void create(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
    }

    public boolean validatePassword(String email, String password) {
        Account account = accountRepository.findByEmail(email).orElseThrow();

        return passwordEncoder.matches(password, account.getPassword());
    }
}
