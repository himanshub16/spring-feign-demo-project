package com.example.feignapi.commons.api;

import com.example.feignapi.commons.dto.HelloResponse;
import com.example.feignapi.commons.dto.Message;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface HelloWorldAPI {
    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HelloResponse> sayHello(@PathVariable("name") String name);

    @PostMapping(value = "/sendMessage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Message> sendMessage(@RequestBody Message message);

    @GetMapping(value = "/evenNumbers", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HelloResponse> evenNumbers(@RequestParam("value") Integer value);
}
