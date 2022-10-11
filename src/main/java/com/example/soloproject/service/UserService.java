package com.example.soloproject.service;

import com.example.soloproject.dto.UserDto;
import com.example.soloproject.entity.UserEntity;
import com.example.soloproject.repository.UserRepository;
import com.example.soloproject.utils.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(UserDto userDto) {

        UserEntity userEntity = ModelMapperUtils.getMapper().map(userDto, UserEntity.class);

        userRepository.save(userEntity);
    }

    public void deleteUser() {
        userRepository.deleteAll();
    }

    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

}
