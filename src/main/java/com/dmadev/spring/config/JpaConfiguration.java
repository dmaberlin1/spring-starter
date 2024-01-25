package com.dmadev.spring.config;

import com.dmadev.spring.config.condition.JpaConditional;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Conditional(JpaConditional.class)
@Configuration
public class JpaConfiguration {

    @PostConstruct
    void init(){
       log.info("Jpa configuration is enabled");
    }
}
