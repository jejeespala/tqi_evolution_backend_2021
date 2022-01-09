package com.loan.company.exception;

public class LoanNotFoundException extends Exception{

    public LoanNotFoundException(Long id){
        super(String.format("Loan with ID %s not found! ", id));
    }
}
