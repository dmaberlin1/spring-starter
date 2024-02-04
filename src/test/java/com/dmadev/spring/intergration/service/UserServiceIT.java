package com.dmadev.spring.intergration.service;

import com.dmadev.spring.config.DatabaseProperties;
import com.dmadev.spring.database.pool.ConnectionPool;
import com.dmadev.spring.dto.CompanyReadDto;
import com.dmadev.spring.intergration.annotation.IT;
import com.dmadev.spring.service.CompanyService;
import com.dmadev.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestConstructor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest(classes = ApplicationRunner.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,
//initializers = ConfigDataApplicationContextInitializer.class)

@IT
@RequiredArgsConstructor
public class UserServiceIT {

    @Autowired
    private UserService userService;


    @Test
    void test(){

    }
}
