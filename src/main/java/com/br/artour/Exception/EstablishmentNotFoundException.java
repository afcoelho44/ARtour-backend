package com.br.artour.Exception;

public class EstablishmentNotFoundException extends RuntimeException{
    public EstablishmentNotFoundException() {
        super("Establishment Not Found");
    }
}
