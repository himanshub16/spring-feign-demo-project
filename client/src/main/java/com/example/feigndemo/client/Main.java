package com.example.feigndemo.client;

import com.example.feignapi.commons.api.HelloWorldAPI;
import com.example.feignapi.commons.dto.HelloResponse;
import com.example.feignapi.commons.dto.Message;
import feign.Feign;
import feign.FeignException;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.http.ResponseEntity;

public class Main {
    private static HelloWorldAPI makeClient() {
        return Feign.builder().contract(new SpringMvcContract()).encoder(new JacksonEncoder()).decoder(new ResponseEntityDecoder(new JacksonDecoder())).target(HelloWorldClient.class, "http://localhost:8080/hello");
    }

    public static void main(String[] args) {
        HelloWorldAPI client = makeClient();

        // hello/name test
        try {
            ResponseEntity<HelloResponse> response = client.sayHello("Himanshu");
            System.out.println(response.getBody());
        } catch (Exception ignored) {
        }

        // send message test
        ResponseEntity<Message> messageResponse = client.sendMessage(new Message("Himanshu", "Trifacta", "Hello everyone!"));
        System.out.println(messageResponse.getBody());

        // query param success test
        System.out.println("even numbers with value 2");
        try {
            ResponseEntity<HelloResponse> response = client.evenNumbers(2);
            System.out.println("response code " + response.getStatusCode() + " content " + response.getBody().getMessage());
        } catch (Exception ignored) {
        }

        // query param HTTP 406 test
        System.out.println("even numbers with value 3");
        try {
            ResponseEntity<HelloResponse> response = client.evenNumbers(3);
            System.out.println("response code " + response.getStatusCode() + " content " + response.getBody().getMessage());
        } catch (FeignException e) {
            System.out.println("exception " + " status " + e.status() + " content " + e.contentUTF8());
        }
    }
}