package com.dmadev.spring.intergration;

import com.dmadev.spring.intergration.annotation.IT;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@IT

public abstract class IntegrationTestBase {
    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:14.1");

    @BeforeAll
    static void runContainer() {
        container.start();
    }
    @DynamicPropertySource
    static void postgresProperties(DynamicPropertySource registry){
        registry.
//       registry.add("spring.datasource.url",container::getJdbcUrl);
    }
}
