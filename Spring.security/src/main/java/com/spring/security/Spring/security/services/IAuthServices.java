package com.spring.security.Spring.security.services;

import com.spring.security.Spring.security.persistence.entities.UserEntity;
import com.spring.security.Spring.security.services.models.dtos.LoginDTO;
import com.spring.security.Spring.security.services.models.dtos.ResponseDTO;

import java.util.HashMap;

public interface IAuthServices {
    public HashMap<String, String> login(LoginDTO login) throws Exception;
    public ResponseDTO register (UserEntity user) throws Exception;
}
