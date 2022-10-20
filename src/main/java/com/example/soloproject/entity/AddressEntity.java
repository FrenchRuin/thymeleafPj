package com.example.soloproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Address")
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;
    private String address;
    private String zipCode;
    private String city;
    private String country;
}
