package com.dmadev.spring.service;

import com.dmadev.spring.database.repository.UserRepository;
import com.dmadev.spring.dto.UserCreateEditDto;
import com.dmadev.spring.dto.UserReadDto;
import com.dmadev.spring.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;

        public List<UserReadDto> findAll(){
            return userRepository.findAll().stream()
                    .map(userReadMapper::map).toList();
        }

        public Optional<UserReadDto> findById(Long id){
            return userRepository.findById(id).map(userReadMapper::map);
        }

        public UserReadDto create(UserCreateEditDto userDto){
            return Optional.of(userDto).map()
        }

}
