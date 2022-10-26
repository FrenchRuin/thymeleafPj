package com.example.soloproject.entity;


import javax.persistence.*;


import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@EqualsAndHashCode
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Board")
public class BoardEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private UserEntity user;
}
