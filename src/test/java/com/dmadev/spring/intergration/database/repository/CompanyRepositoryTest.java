package com.dmadev.spring.intergration.database.repository;

import com.dmadev.spring.database.entity.Company;
import com.dmadev.spring.database.repository.CompanyRepository;
import com.dmadev.spring.intergration.IntegrationTestBase;
import com.dmadev.spring.intergration.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
//@Rollback // после каждого метода чистить оставшиеся результаты теста
//@Commit //убирает дефолт и делает выполнение транзакции после каждого теса
class CompanyRepositoryTest extends IntegrationTestBase {

    private static final Integer APPLE_ID=5;
    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;

    @Test
    void checkFindByQueries(){
        companyRepository.findByName("Google");
        companyRepository.findAllByNameContainingIgnoreCase("a");
    }

    @Test
    void delete(){
        Optional<Company> maybeCompany = companyRepository.findById(APPLE_ID);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
    }

    @Test
    void findById() {
        var company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void save() {
        Company company = Company.builder().name("Apple").locales(Map.of(
                "ru", "Apple описание",
                "en", "Apple descripton")).build();

        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}












