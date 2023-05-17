package com.example.feignapi.commons.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface HelloWorldAPI {
    @GetMapping("/hello/{name}")
    ResponseEntity<String> sayHello(@PathVariable("name") String name);
}
