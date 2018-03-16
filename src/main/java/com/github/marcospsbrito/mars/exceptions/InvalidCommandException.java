package com.github.marcospsbrito.mars.exceptions;

import com.github.marcospsbrito.mars.domain.Curiosity;

/**
 * Created by marcos on 15/03/18.
 */
public class InvalidCommandException extends RuntimeException{

    public InvalidCommandException(String command){
        super("Invalid Command - "+ command);
    }
}
