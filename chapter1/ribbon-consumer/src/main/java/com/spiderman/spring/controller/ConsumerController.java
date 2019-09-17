package com.spiderman.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
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
public class ConsumerController {

    /**
     * 服务发现客户端
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getHelloConsumer",method = RequestMethod.GET)
    public String getHelloConsumer(){
        String paramName="SpiderMan";
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello/{1}",String.class,paramName).getBody();
    }

    /**
     * post请求测试
     * @return
     */
    @RequestMapping(value = "/postHelloConsumer",method = RequestMethod.POST)
    public String postHelloConsumer(){
        Map param=new HashMap<String,Object>(){{
            put("name","SpiderMan");
            put("age",30);
        }};
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(param, headers);
        return restTemplate.postForEntity("http://HELLO-SERVICE/postTest",httpEntity,String.class).getBody();
    }
}
