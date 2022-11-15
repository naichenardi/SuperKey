package com.superkey.controllers;

import com.superkey.controllers.dto.AccountDTO;
import com.superkey.db.entities.Account;
import com.superkey.services.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;
    private final PasswordEncoder passwordEncoder;

    public AccountController(AccountService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<AccountDTO> findAllAccounts(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        return service.findAll(Pageable.ofSize(size).withPage(page));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountDTO account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        service.create(account.toEntity());
    }

}