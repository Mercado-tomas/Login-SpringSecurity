package com.spring.security.Spring.security.services.models.dtos;

public class ResponseDTO {

    private  int numOfErros;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumOfErros() {
        return numOfErros;
    }

    public void setNumOfErros(int numOfErros) {
        this.numOfErros = numOfErros;
    }
}
