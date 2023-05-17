package com.example.feigndemo.client;

import com.example.feignapi.commons.api.HelloWorldAPI;
import feign.Feign;
import feign.codec.Decoder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.http.ResponseEntity;

public class Main {
    private static HelloWorldAPI makeClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new ResponseEntityDecoder(new Decoder.Default()))
                .target(HelloWorldClient.class, "http://localhost:8080");
    }

    public static void main(String[] args) {
        HelloWorldAPI client = makeClient();
        ResponseEntity<String> response = client.sayHello("Vipul");
        System.out.println(response.getBody());
    }
}