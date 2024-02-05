package com.dmadev.spring.database.repository;

import com.dmadev.spring.database.entity.Role;
import com.dmadev.spring.database.entity.User;
import com.dmadev.spring.dto.PersonalInfo;
import com.dmadev.spring.dto.UserFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class FilterUserRepositoryImpl {
    private static final String UPDATE_COMPANY_AND_ROLE = """
            UPDATE users
            set company_id= ?,
            role= ?
            where id= ?
                        
            """;


    List<User> findAllByFilter(UserFilter filter) {
        return new ArrayList<User>();
    }

    ;

//    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role){
//        return Collections.singletonList(PersonalInfo);
//    }

    void updateCompanyAndRole(List<User> users) {
       var args = users.stream().map(user -> new Object[]{user.getCompany().getId(), user.getRole().name(), user.getId()}).toList();
//        jdbcTemplate.batchUpdate(UPDATE_COMPANY_AND_ROLE,args)
    }

    ;
}
