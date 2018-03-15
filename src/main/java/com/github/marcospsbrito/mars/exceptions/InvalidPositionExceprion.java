package com.github.marcospsbrito.mars.exceptions;

/**
 * Created by marcos on 15/03/18.
 */
public class InvalidPositionExceprion extends RuntimeException{

    public InvalidPositionExceprion (String command){
        super("Comando inválido: "+ command);
    }
}
