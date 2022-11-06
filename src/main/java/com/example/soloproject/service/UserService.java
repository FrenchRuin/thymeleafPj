package com.example.soloproject.service;

import com.example.soloproject.dto.UserDto;
import com.example.soloproject.entity.UserEntity;
import com.example.soloproject.converter.UserRole;
import com.example.soloproject.repository.AddressRepository;
import com.example.soloproject.repository.UserRepository;
import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapperUtils modelMapper;

    public void addUser(UserDto userDto) {
//        if (userDto.getUserId().equals("toxic023")) {
//            userDto.setRole(UserRole.ROLE_ADMIN);
//        }else{
//            userDto.setRole(UserRole.ROLE_USER);
//        }
        UserEntity userEntity = modelMapper.getMapper().map(userDto, UserEntity.class);
        userRepository.save(userEntity);

        log.info("userEntity : {}", userEntity);
    }

    public List<UserDto> findAllUser() {

//        List<UserEntity> userEntityList = userRepository.findAllData();
        List<UserEntity> userEntityList = userRepository.findAll();
        /* List UserEntity  >> List UserDto */
        List<UserDto> userDtoList = userEntityList.stream()
                .map(userEntity ->
                        modelMapper.getMapper().map(userEntity,UserDto.class))
                .collect(Collectors.toList());

        return userDtoList;
    }

    public UserDto findUser(String userId) {
        UserEntity userEntity = new UserEntity();

        UserDto userDto = modelMapper.getMapper().map(userEntity, UserDto.class);
        return userDto;
    }


    public void saveUserDetail(UserDto userDto) {
        UserEntity userEntity = modelMapper.getMapper().map(userDto, UserEntity.class);
        userRepository.save(userEntity);
    }


    public void deleteAllUser() {
        userRepository.deleteAll();
    }






//    private UserEntity userDtoToEntity(UserDto dto){
//
//        UserEntity entity = new UserEntity();
//
//        entity.setId(dto.getId());
//        entity.setUserId(dto.getUser_id());
//        entity.setName(dto.getName());
//        entity.setNumber(dto.getNumber());
//        entity.setBirth(dto.getBirth());
//        entity.setPassword(dto.getPassword());
//        entity.setEmail(dto.getEmail());
//
//        return entity;
//    }
//
//    private UserDto userEntityToDto(UserEntity entity){
//
//        UserDto dto = new UserDto();
//
//        dto.setId(entity.getId());
//        dto.setUser_id(entity.getUserId());
//        dto.setName(entity.getName());
//        dto.setNumber(entity.getNumber());
//        dto.setBirth(entity.getBirth());
//        dto.setPassword(entity.getPassword());
//        dto.setEmail(entity.getEmail());
//
//        return dto;
//    }


}
