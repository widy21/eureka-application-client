package com.hx.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huaxiao on 2019/6/1.
 */
@RestController
@RequestMapping("customer")
public class TestController {

    @Value("${server.port}")
    private String port;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("get")
    @ResponseBody
    public String get(String name)
    {
        return restTemplate.getForObject("http://order/order/create?name=hx",String.class,"");
    }
}
