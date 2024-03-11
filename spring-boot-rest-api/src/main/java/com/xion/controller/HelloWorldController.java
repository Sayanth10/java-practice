package com.xion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // Rest API returns a String
    @GetMapping("/hello-world")
    public String sayHelloWorld() {
        return "Hello World!!";
    }
}
