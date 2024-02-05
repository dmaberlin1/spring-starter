package com.dmadev.spring.database.repository;

import com.dmadev.spring.database.entity.Role;
import com.dmadev.spring.database.entity.User;
import com.dmadev.spring.dto.PersonalInfo;
import com.dmadev.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole();
}
