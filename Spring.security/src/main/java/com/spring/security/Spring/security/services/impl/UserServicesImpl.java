package com.spring.security.Spring.security.services.impl;


import com.spring.security.Spring.security.persistence.entities.UserEntity;
import com.spring.security.Spring.security.persistence.repositories.UserRepositorie;
import com.spring.security.Spring.security.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServicesImpl implements IUserServices {
    @Autowired
    UserRepositorie userRepositorie;

    @Override
    public List<UserEntity> findAllUser() {
        return userRepositorie.findAll();
    }


}
