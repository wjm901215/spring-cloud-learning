package com.spiderman.spring.eruekaserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网关hystrix降级处理
 */
@RestController
public class FallbackController {
    @RequestMapping("/defaultFallback")
    public String fallback() {
        return "服务器发生hystrix降级处理";
    }
}