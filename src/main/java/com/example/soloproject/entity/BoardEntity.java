package com.example.soloproject.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.*;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "Board")
public class BoardEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;
    private String title;
    private String content;
}
