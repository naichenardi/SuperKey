package com.superkey.services;

import com.superkey.controllers.dto.AccountDTO;
import com.superkey.controllers.dto.TokenResponse;
import com.superkey.db.entities.Account;
import com.superkey.db.repositories.AccountRepository;
import com.superkey.jwt.service.JwtUtils;
import com.superkey.jwt.service.UserDetailsImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public Page<AccountDTO> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable).map(Account::toDTO);
    }

    public void create(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
    }

    public TokenResponse validatePassword(String email, String password) {
        Account account = accountRepository.findByEmail(email).orElseThrow();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());


        return new TokenResponse(jwt);
    }
}
