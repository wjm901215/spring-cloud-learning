package com.spiderman.spring.eruekaserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    /**
     * get 测试方法
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public String index(@PathVariable("name") String name){
        List<ServiceInstance> listInstance=client.getInstances("hello-service");
        if(listInstance!=null&&listInstance.size()>0){
            listInstance.forEach(serviceInstance -> log.info("/hello,host:"+serviceInstance.getHost()+",service_id:"+serviceInstance.getServiceId()));
        }
        return "Hello "+name;
    }

    /**
     * post 测试方法
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/postTest",method = RequestMethod.POST)
    public String postTest(@RequestBody Map paramMap){
        List<ServiceInstance> listInstance=client.getInstances("hello-service");
        if(listInstance!=null&&listInstance.size()>0){
            listInstance.forEach(serviceInstance -> log.info("/hello,host:"+serviceInstance.getHost()+",service_id:"+serviceInstance.getServiceId()));
        }

        String content="";
        Iterator<Map.Entry<String,Object>> entries= paramMap.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<String,Object> entry = entries.next();
            log.info("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            content+=" Key = " + entry.getKey() + ", Value = " + entry.getValue();
        }
        return content;
    }
}
