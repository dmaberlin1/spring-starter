package com.dmadev.spring.intergration.database.repository;

import com.dmadev.spring.database.entity.Company;
import com.dmadev.spring.database.entity.User;
import com.dmadev.spring.database.repository.CompanyRepository;
import com.dmadev.spring.database.repository.UserRepository;
import com.dmadev.spring.intergration.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
//@Rollback // после каждого метода чистить оставшиеся результаты теста
//@Commit //убирает дефолт и делает выполнение транзакции после каждого теса
class UserRepositoryTest {

private final UserRepository userRepository;

    @Test
    void checkAuditing(){
        User ivan = userRepository.findById(1L).get();
        ivan.setBirthDate(ivan.getBirthDate().plusYears(1L));
        userRepository.flush();
    }
}












