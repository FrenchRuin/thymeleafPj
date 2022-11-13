package com.example.soloproject.dto;

import com.example.soloproject.converter.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private AccountDto account;
    private String name;
    private String number;
    private String birth;
    private String email;
    private AddressDto address;
    private List<BoardDto> boards = new ArrayList<>();

    private Set<GrantedAuthority> role;


}
