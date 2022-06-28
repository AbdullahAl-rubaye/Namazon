package com.codedifferently.namazonshoping.exceptions;

public class AccountDoesntExistException extends Exception{
    public AccountDoesntExistException(String msg){
        super(msg);
    }

}
