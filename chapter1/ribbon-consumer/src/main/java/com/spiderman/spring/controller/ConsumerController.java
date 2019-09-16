package com.spiderman.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author Spiderman
 * @version v1.0.0: com.spiderman.spring.eruekaserver.controller.HelloController,v 0.1 2019-09-11 19:26 Exp $$
 */
@RestController
@Slf4j
public class ConsumerController {

    /**
     * 服务发现客户端
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }
}
