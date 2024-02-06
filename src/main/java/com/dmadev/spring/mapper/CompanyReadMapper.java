package com.dmadev.spring.mapper;

import com.dmadev.spring.database.entity.Company;
import com.dmadev.spring.database.entity.User;
import com.dmadev.spring.dto.CompanyReadDto;
import com.dmadev.spring.dto.UserReadDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto>{


    @Override
    public CompanyReadDto map(Company object) {
        return new CompanyReadDto(
                object.getId(),
                object.getName()
        );
    }
}
