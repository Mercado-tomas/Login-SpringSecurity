package com.spring.security.Spring.security.controllers;

import com.spring.security.Spring.security.persistence.entities.UserEntity;
import com.spring.security.Spring.security.services.IUserServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllers {
    // inyeccion de dependecias
    @Autowired
    IUserServices userServices;
    @GetMapping("/find-all")
    private ResponseEntity<List<UserEntity>> getAllUser(){
        return new ResponseEntity<>(userServices.findAllUser(), HttpStatus.OK);
    }
}
