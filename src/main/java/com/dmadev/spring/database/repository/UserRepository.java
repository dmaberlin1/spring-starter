package com.dmadev.spring.database.repository;

import com.dmadev.spring.database.entity.User;
import com.dmadev.spring.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@RequiredArgsConstructor
public interface UserRepository extends JpaRepository<User,Long> {

//    @Qualifier("pool1")
//    final ConnectionPool connectionPool;

}
