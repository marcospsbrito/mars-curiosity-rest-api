package com.github.marcospsbrito.mars.exceptions;

/**
 * Created by marcos on 15/03/18.
 */
public class InvalidPositionException extends RuntimeException{

    public InvalidPositionException(String command){
        super("Invalid Position - "+ command);
    }
}
