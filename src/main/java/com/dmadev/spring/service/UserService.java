package com.dmadev.spring.service;

import com.dmadev.spring.repository.CompanyRepository;
import com.dmadev.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;


}
