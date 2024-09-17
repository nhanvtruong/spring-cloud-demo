package com.example.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Configuration
public class GatewayConfig {

    private static final Logger log = LoggerFactory.getLogger(GatewayConfig.class);

    @Bean
    public KeyResolver keyResolver() {

        return exchange -> {
            String remoteHostAddress = Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress();
            log.info("Method {} ,Path {} ,Remote Host Address {}", exchange.getRequest().getMethod(), exchange.getRequest().getPath(), remoteHostAddress);
            return Mono.just(remoteHostAddress);
        };
    }
}
