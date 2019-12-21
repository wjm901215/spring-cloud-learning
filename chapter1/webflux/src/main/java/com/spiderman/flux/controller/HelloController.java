package com.spiderman.flux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {
    /**
     * 命令式的、同步阻塞的【spring-webmvc + servlet + Tomcat】
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        return "Welcome to reactive world ~";
    }

    /**
     * 响应式的、异步非阻塞的【spring-webflux + Reactor + Netty】
     * @return
     */
    @GetMapping("/helloFlux")
    public Mono<String> helloFlux() {
        //使用Mono.just生成响应式数据
        return Mono.just("Welcome to reactive world ~");
    }
}