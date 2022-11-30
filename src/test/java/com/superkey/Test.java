package com.superkey;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("123");
        System.out.println(encode);
        System.out.println("$2a$10$QqGfMgCgTagfgc9Sy0moC.7H6kM/h0PGrAUsU98wL2t2LY65XxRR6");
    }
}
