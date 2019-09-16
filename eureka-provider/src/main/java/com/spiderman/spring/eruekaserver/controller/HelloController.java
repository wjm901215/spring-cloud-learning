package com.spiderman.spring.eruekaserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class HelloController {

    /**
     * 服务发现客户端
     */
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index(){
        List<ServiceInstance> listInstance=client.getInstances("hello-service");
        if(listInstance!=null&&listInstance.size()>0){
            listInstance.forEach(serviceInstance -> log.info("/hello,host:"+serviceInstance.getHost()+",service_id:"+serviceInstance.getServiceId()));
        }
        return "Hello Word";
    }
}
