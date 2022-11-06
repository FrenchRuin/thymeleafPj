package com.example.soloproject.dto;

import com.example.soloproject.converter.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private Long id;

    private String userId;

    private String password;

    private UserRole role;
}
