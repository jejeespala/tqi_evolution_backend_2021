package com.loan.company.exception;

public class ClientNotFoundException extends Exception{

    public ClientNotFoundException(Long id){
        super(String.format("Client with ID %s not found! ", id));
    }
}
