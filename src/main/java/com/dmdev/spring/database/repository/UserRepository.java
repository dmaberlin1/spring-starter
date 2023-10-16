package com.dmdev.spring.database.repository;

import com.dmdev.spring.database.pool.ConnectionPool;

import java.sql.Connection;

public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
