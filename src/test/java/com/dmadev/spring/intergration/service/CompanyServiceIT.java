package com.dmadev.spring.intergration.service;

import com.dmadev.spring.ApplicationRunner;
import com.dmadev.spring.config.DatabaseProperties;
import com.dmadev.spring.database.entity.Company;
import com.dmadev.spring.dto.CompanyReadDto;
import com.dmadev.spring.intergration.annotation.IT;
import com.dmadev.spring.listener.entity.EntityEvent;
import com.dmadev.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

//@SpringBootTest(classes = ApplicationRunner.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,
//initializers = ConfigDataApplicationContextInitializer.class)
@IT
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {

    private static final Integer COMPANY_ID=1;

    private final CompanyService companyService;

    private final DatabaseProperties databaseProperties;

    @Test
    void findById(){
        //given

        //when
        Optional<CompanyReadDto> actualResult = companyService.findById(COMPANY_ID);

        //then
        assertTrue(actualResult.isPresent());

        CompanyReadDto expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual ->assertEquals(expectedResult,actual));

    }
}
