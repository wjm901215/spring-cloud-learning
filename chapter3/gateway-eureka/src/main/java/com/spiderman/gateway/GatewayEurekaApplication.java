package com.spiderman.gateway;

import com.spiderman.gateway.config.HostAddrKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayEurekaApplication.class, args);
    }
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver(){
        return new HostAddrKeyResolver();
    }

}
