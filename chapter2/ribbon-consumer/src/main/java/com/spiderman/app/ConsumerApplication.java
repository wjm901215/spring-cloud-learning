package com.spiderman.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author Spiderman
 * @version 1.0.0: com.spiderman.app.ConsumerApplication,v 0.1 2019-09-12 17:34 Exp $$
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
