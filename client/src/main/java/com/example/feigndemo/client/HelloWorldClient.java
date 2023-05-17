package com.example.feigndemo.client;

import com.example.feignapi.commons.api.HelloWorldAPI;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient
public interface HelloWorldClient extends HelloWorldAPI {
}
