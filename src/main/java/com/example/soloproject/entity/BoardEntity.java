package com.example.soloproject.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.soloproject.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BoardEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String title;
    private String content;
}
