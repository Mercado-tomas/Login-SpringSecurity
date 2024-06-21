package com.spring.security.Spring.security.services;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

public interface IJWTUtilityService {
    // excepsiones a manejar por clase que implemente esta interfaz
    public String generatedJWT (Integer userId) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, JOSEException;
    // excepsiones para tockens
    public JWTClaimsSet parseJWT(String jwt) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, ParseException, JOSEException;

}
