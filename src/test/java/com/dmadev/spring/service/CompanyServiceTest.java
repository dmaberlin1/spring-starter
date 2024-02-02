package com.dmadev.spring.service;

import com.dmadev.spring.database.entity.Company;
import com.dmadev.spring.database.repository.CrudRepository;
import com.dmadev.spring.dto.CompanyReadDto;
import com.dmadev.spring.listener.entity.EntityEvent;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    //given
    //when
    //then

    private static final Long COMPANY_ID=1L;
    @Mock
    private  CrudRepository<Long, Company> companyRepository;
    @Mock
    private  UserService userService;
    @Mock
    private  ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        //given
        doReturn(Optional.of(new Company(COMPANY_ID)))
                .when(companyRepository).findById(COMPANY_ID);
        //when
        Optional<CompanyReadDto> actualResult = companyService.findById(COMPANY_ID);

        //then
        assertTrue(actualResult.isPresent());

        CompanyReadDto expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual ->assertEquals(expectedResult,actual));

        verify(eventPublisher).publishEvent(any(EntityEvent.class));
//        verifyNoInteractions(eventPublisher,userService);

    }
}