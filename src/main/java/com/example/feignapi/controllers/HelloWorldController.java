package com.example.feignapi.controllers;

import com.example.feignapi.commons.api.HelloWorldAPI;
import com.example.feignapi.commons.dto.HelloResponse;
import com.example.feignapi.commons.dto.Message;
import com.example.feignapi.internal.HelloWorldInternalAPI;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/hello")
public final class HelloWorldController implements HelloWorldAPI, HelloWorldInternalAPI {

    @Override
    public ResponseEntity<HelloResponse> sayHello(String name) {
        return ResponseEntity.ok(new HelloResponse("Hello " + name + "!"));
    }

    @Override
    public ResponseEntity<Message> sendMessage(Message message) {
        return ResponseEntity.ok(message);
    }

    @Override
    public ResponseEntity<HelloResponse> evenNumbers(Integer value) {
        if (value % 2 == 0) {
            return ResponseEntity.ok(new HelloResponse("Hello with value " + value));
        } else {
            return new ResponseEntity<>(new HelloResponse(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // this comes from HelloWorldInternalAPI. This can be restricted from the client and can be protected from outside access using proxy-rules, extra-auth, etc.
    @Override
    public ResponseEntity<HelloResponse> tellAdminName() {
        return ResponseEntity.ok(new HelloResponse("The President"));
    }
}
