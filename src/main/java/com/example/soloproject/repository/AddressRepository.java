package com.example.soloproject.repository;


import com.example.soloproject.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity,Long> {


    /* Not recommend Update Query Use //

    @Modifying
    @Query("Update address a set a.city = :city, a.country = :country, a.zip_code = :zipCode, a.address = :address where a.user_id = :userId ")
    void updateUserAddress(
            @Param("city") String city,
            @Param("country") String country,
            @Param("zipCode") String zipCode,
            @Param("address") String address,
            @Param("userId") String userId);
    */

}
