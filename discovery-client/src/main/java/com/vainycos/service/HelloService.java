package com.vainycos.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Vainycos
 * @description
 * @date 2021/8/6 15:46
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://CLIENT-1/hi?name=" + name, String.class);
    }

    public String hiError(String name){
        return "hey" + name + ", there is some problem with hi page";
    }


}