package com.dmadev.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "db")
public class DatabaseProperties {
    private String    username;
    private String password;
    private String driver;
    private String hosts;
    private PoolProperties pool;
    private List<PoolProperties> pools;

    public static class PoolProperties{
        private Integer size;
        private Integer timeout;
    }

}
