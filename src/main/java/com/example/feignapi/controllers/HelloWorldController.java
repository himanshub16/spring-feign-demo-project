package com.example.feignapi.controllers;

import com.example.feignapi.commons.api.HelloWorldAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HelloWorldController implements HelloWorldAPI {

    @Override
    @GetMapping("/hello/{name}")
    public ResponseEntity<String> sayHello(@PathVariable("name") String name) {
        return ResponseEntity.ok("Hello " + name + "!");
    }
}
