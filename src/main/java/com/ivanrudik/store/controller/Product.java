package com.ivanrudik.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Product {

    @GetMapping("/")
    public String product() {
        return "Start";
    }
}
