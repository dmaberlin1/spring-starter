package com.dmadev.spring.service;

import com.dmadev.spring.database.repository.UserRepository;
import com.dmadev.spring.dto.UserCreateEditDto;
import com.dmadev.spring.dto.UserReadDto;
import com.dmadev.spring.mapper.UserCreateEditMapper;
import com.dmadev.spring.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional()
// readOnly= Преимущество в Hibernate- не будет делать flush нашей сессии, нам это не нужно в рид онли транзакциях
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map).toList();
    }

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id).map(userReadMapper::map);
    }



    public UserReadDto create(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(userCreateEditMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();

    }


    public Optional<UserReadDto> update(Long id,UserCreateEditDto userDto){
        return userRepository.findById(id)
                .map(entity->userCreateEditMapper.map(userDto,entity))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }


    public boolean delete(Long id){
        return userRepository.findById(id).map(entity->{
            userRepository.delete(entity);
            userRepository.flush();
            return true;
        }).orElse(false);
    }

}
