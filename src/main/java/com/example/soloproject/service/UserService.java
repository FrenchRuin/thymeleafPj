package com.example.soloproject.service;

import com.example.soloproject.dto.UserDto;
import com.example.soloproject.entity.UserEntity;
import com.example.soloproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserDto userDto) {
        UserEntity userEntity = userDtoToEntity(userDto);

        userRepository.save(userEntity);

        log.info("userEntity : {}", userEntity);
    }


    public void deleteUser(UserDto userDto) {

        userRepository.deleteById(userDto.getId());
    }



    private UserEntity userDtoToEntity(UserDto dto){

        UserEntity entity = new UserEntity();

        entity.setId(dto.getId());
        entity.setUserId(dto.getUser_id());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setNumber(dto.getNumber());
        entity.setBirth(dto.getBirth());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());

        return entity;
    }

    private UserDto userEntityToDto(UserEntity entity){

        UserDto dto = new UserDto();

        dto.setId(entity.getId());
        dto.setUser_id(entity.getUserId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setNumber(entity.getNumber());
        dto.setBirth(entity.getBirth());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());

        return dto;
    }


}
