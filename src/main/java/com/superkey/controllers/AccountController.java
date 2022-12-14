package com.superkey.controllers;

import com.superkey.controllers.dto.AccountDTO;
import com.superkey.services.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
//    @Operation(summary = "List all Accounts", description = "List all accounts in database")
    @ResponseBody
    public Page<AccountDTO> findAllAccounts(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        return service.findAll(Pageable.ofSize(size).withPage(page));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountDTO account) {
        service.create(account.toEntity());
    }


}