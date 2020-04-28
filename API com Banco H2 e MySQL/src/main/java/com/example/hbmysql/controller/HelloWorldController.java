package com.example.hbmysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harvey Braun
 * @version 1.0
 * @since 25/04/2020
 */
@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String index() {
        return "Seja Bem Vindo ao Sistema";
    }
}

