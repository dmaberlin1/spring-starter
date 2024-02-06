package com.dmadev.spring.mapper;

import com.dmadev.spring.database.entity.Company;
import com.dmadev.spring.database.entity.User;
import com.dmadev.spring.database.repository.CompanyRepository;
import com.dmadev.spring.dto.UserCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    private final CompanyRepository companyRepository;

    @Override
    public User map(UserCreateEditDto object) {
        User user=new User();
        user.setUsername(object.getUsername());
        user.setFirstName(object.getFirstname());
        user.setLastname(object.getLastname());
        user.setBirthDate(object.getBirthDate());
        user.setRole(object.getRole());
        user.setCompany(getCompany(object.getCompanyId()));
        return user;
    }
    private Company getCompany(Integer companyId){
        return Optional.ofNullable(companyId).flatMap(companyRepository::findById).orElse(null);
    }
}
