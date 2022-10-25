package com.example.soloproject.converter;

import com.example.soloproject.dto.UserDto;
import com.example.soloproject.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity userDtoToEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .userId(userDto.getUserId())
                .birth(userDto.getBirth())
                .email(userDto.getEmail())
                .number(userDto.getNumber())
                .name(userDto.getName())
                .build();

    }

    public UserEntity onlyUserDtoToEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .userId(userDto.getUserId())
                .birth(userDto.getBirth())
                .email(userDto.getEmail())
                .number(userDto.getNumber())
                .name(userDto.getName())
                .build();

    }

    public UserDto onlyUserEntityToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .userId(userEntity.getUserId())
                .email(userEntity.getEmail())
                .birth(userEntity.getBirth())
                .number(userEntity.getNumber())
                .build();
    }
}
