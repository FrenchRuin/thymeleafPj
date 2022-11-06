package com.example.soloproject.entity;

import com.example.soloproject.converter.UserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Account")
public class AccountEntity {

    @GeneratedValue
    @Id
    private Long id;

    private String userId;

    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(updatable = false)
    private LocalDateTime updatedAt;
}
