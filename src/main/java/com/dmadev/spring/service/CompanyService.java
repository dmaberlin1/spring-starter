package com.dmadev.spring.service;

import com.dmadev.spring.database.entity.Company;
import com.dmadev.spring.dto.CompanyReadDto;
import com.dmadev.spring.listener.entity.AccessType;
import com.dmadev.spring.listener.entity.EntityEvent;
import com.dmadev.spring.database.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CrudRepository<Long, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    public Optional<CompanyReadDto> findById(Long id) {
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }
}