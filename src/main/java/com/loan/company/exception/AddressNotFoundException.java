package com.loan.company.exception;

public class AddressNotFoundException extends Exception{

    public AddressNotFoundException(Long id){
        super(String.format("Address with ID %s not found! ", id));
    }
}
