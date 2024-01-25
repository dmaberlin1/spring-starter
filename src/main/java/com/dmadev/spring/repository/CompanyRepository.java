package com.dmadev.spring.repository;

import com.dmadev.spring.database.entity.Company;
import com.dmadev.spring.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompanyRepository  implements CrudRepository<Integer, Company>{

    private final ConnectionPool connectionPool;
    @Value("{db.pool.size}")
    private final Integer poolSize;

}
