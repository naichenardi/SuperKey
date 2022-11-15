package com.superkey.services;

import com.superkey.controllers.dto.AccountDTO;
import com.superkey.db.entities.Account;
import com.superkey.db.repositories.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Page<AccountDTO> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable).map(Account::toDTO);
    }

    public void create(Account account) {
        accountRepository.save(account);
    }
}
