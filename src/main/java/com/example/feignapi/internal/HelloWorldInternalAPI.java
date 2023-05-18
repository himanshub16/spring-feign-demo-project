package com.example.feignapi.internal;

import com.example.feignapi.commons.dto.HelloResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface HelloWorldInternalAPI {
    @GetMapping(value = "/tellAdminName", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HelloResponse> tellAdminName();
}
