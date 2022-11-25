package com.superkey.controllers;

import com.superkey.controllers.dto.AccountDTO;
import com.superkey.controllers.dto.TokenResponse;
import com.superkey.db.entities.Account;
import com.superkey.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "List all Accounts", description = "List all accounts in database")
    @SecurityRequirement(name = "Bearer Authentication")
    @ResponseBody
    public Page<AccountDTO> findAllAccounts(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        return service.findAll(Pageable.ofSize(size).withPage(page));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountDTO account) {

        service.create(account.toEntity());
    }


    @PostMapping(value = "/login", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenResponse> validateUserPassword(@Valid @RequestBody AccountDTO account) {
        TokenResponse tokenResponse = service.validatePassword(account.getEmail(), account.getPassword());

        HttpStatus status = null == tokenResponse ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(tokenResponse);
    }

}