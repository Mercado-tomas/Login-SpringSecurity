package com.spring.security.Spring.security.services.impl;

import com.spring.security.Spring.security.persistence.entities.UserEntity;
import com.spring.security.Spring.security.persistence.repositories.UserRepositorie;
import com.spring.security.Spring.security.services.IAuthServices;
import com.spring.security.Spring.security.services.IJWTUtilityService;
import com.spring.security.Spring.security.services.models.dtos.LoginDTO;
import com.spring.security.Spring.security.services.models.dtos.ResponseDTO;
import com.spring.security.Spring.security.services.models.validations.UserValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthServices {
    // conectamos los objetos e instanciamos
    @Autowired
    private UserRepositorie userRepositorie;

    @Autowired
    private IJWTUtilityService jwtUtilityService;

    @Autowired
    private UserValidations userValidations;

    // metodo para buscar al usuario por email
    @Override
    public HashMap<String, String> login(LoginDTO login) throws Exception {
        try {
            HashMap<String,String> jwt = new HashMap<>();
            // usara el metodo que creamos con la query nativa
            Optional<UserEntity> user = userRepositorie.findByEmail(login.getEmail());
            if(user.isEmpty()){
                jwt.put("Error","User not registered!");
                return jwt;
            }

            // verificar la contraseña
            if(verifyPassword(login.getPassword(), user.get().getPassword())){
                jwt.put("jwt", jwtUtilityService.generatedJWT(user.get().getId()));
            }else {
                jwt.put("Error", "Authentication failed!");
            }

            return jwt;

        }catch (Exception e){
            throw new Exception((e.toString()));
        }



    }
    // metodo para registrar y validar
    public ResponseDTO register (UserEntity user) throws Exception {
        try {
            ResponseDTO response = userValidations.validate(user);

            // validamos
            if(response.getNumOfErros() > 0){
                return response;
            }
            // busca a todos los usuarios
            List<UserEntity> getAllUsers = userRepositorie.findAll();
            for(UserEntity repetFields : getAllUsers){
                if(repetFields != null){
                    response.setNumOfErros(1);
                    response.setMessage("User already exists!");
                    return response;
                }
            }
            // encriptaremos la contraseña
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            user.setPassword(encoder.encode(user.getPassword()));
            // guardamos al usuario en base de datos
            userRepositorie.save(user);
            // enviamos mensaje de ok
            response.setMessage("User created succesfully!");

            return response;
        }catch (Exception e){
            throw new Exception(e.toString());
        }
    }


    // metodo para verificar contraseña
    private boolean verifyPassword(String enteredPassword, String storedPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, storedPassword);
    }

}
