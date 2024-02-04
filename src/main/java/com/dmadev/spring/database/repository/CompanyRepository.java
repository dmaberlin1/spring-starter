package com.dmadev.spring.database.repository;

import com.dmadev.spring.database.entity.Company;
import com.dmadev.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


//@Slf4j
//@Repository
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@Transaction
//@Auditing
//@RequiredArgsConstructor
//  implements org.springframework.data.repository.Repository<Company,Integer>
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    //Optional,Entity,Future
    Optional<Company> findByName(String name);

    //Collection,Stream(batch size,close)
    List<Company> findAllByNameContainingIgnoreCase(String fragment);

}



