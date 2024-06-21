package com.spring.security.Spring.security.services;

import com.spring.security.Spring.security.persistence.entities.UserEntity;

import java.util.List;

public interface IUserServices {
    public List<UserEntity> findAllUser();
}
