package com.spring.security.Spring.security.persistence.repositories;

import com.spring.security.Spring.security.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepositorie extends JpaRepository<UserEntity, Integer> {
    // validará el email con una query a base de datos
    @Query(value = "SELECT * FROM user WHERE email= :email", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);
}
