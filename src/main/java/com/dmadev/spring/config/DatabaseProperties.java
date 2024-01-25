package com.dmadev.spring.config;

import java.util.List;

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
