package com.spring.security.Spring.security.services.models.validations;

import com.spring.security.Spring.security.persistence.entities.UserEntity;
import com.spring.security.Spring.security.services.models.dtos.ResponseDTO;

public class UserValidations {
    // creamos un metodo que hará las validaciones
    public ResponseDTO validate(UserEntity user){
        // instanciamos un objeto de tipo RespondeDTO
        // el cual tendra los atributos de la clase RespondeDTO
        ResponseDTO response = new ResponseDTO();
        response.setNumOfErros(0);
        // validaciones de campos
        if(user.getFirstName() == null ||
                user.getFirstName().length() < 3 ||
                user.getFirstName().length() > 15){
            response.setNumOfErros(response.getNumOfErros() + 1);
            response.setMessage("El campo first name no puede ser nulo, tambien tiene que tener entre 3 y 15 caracteres");
        }

        if(user.getLastName() == null ||
           user.getLastName().length() < 3 ||
            user.getLastName().length() > 20){
            response.setNumOfErros(response.getNumOfErros() + 1);
            response.setMessage("El campo last name no puede ser nulo, tambien tiene que tener entre 3 y 20 caracteres");
        }

        if(user.getEmail() == null ||
           !user.getEmail().matches("^[\\w-+]+(\\.[\\w-]{1,62}){0,126}@[\\w-]{1,63}(\\.[\\w-]{1,62})+/[\\w-]+$")){
            response.setNumOfErros(response.getNumOfErros() + 1);
            response.setMessage("El email no es valido!");
        }

        if(user.getPassword() == null ||
                !user.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")){
            response.setNumOfErros(response.getNumOfErros() + 1);
            response.setMessage("La contraseña debe de tener entre 8 y 16 caracteres, al menos un numero, una minuscula y una mayuscula");

        }
        return response;
    }
}
