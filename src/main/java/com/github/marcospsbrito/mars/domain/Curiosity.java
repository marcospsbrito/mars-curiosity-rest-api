package com.github.marcospsbrito.mars.domain;

import com.github.marcospsbrito.mars.domain.movements.AheadMovement;
import com.github.marcospsbrito.mars.domain.movements.Movement;
import com.github.marcospsbrito.mars.domain.movements.TurnLeftMovement;
import com.github.marcospsbrito.mars.domain.movements.TurnRightMovement;
import com.github.marcospsbrito.mars.exceptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcos on 15/03/18.
 */
public class Curiosity extends MarsRobot{

    @Override
    protected void init() {
        this.setXPosition(0);
        this.setYPosition(0);
        this.setOrientation(Orientation.N);
    }

    @Override
    protected List<Movement> recognizeMovements(String movements) {
        movements = movements.toUpperCase();
        if(!movements.matches("[M|L|R]*")){
            throw new InvalidCommandException(movements);
        }

        List<Movement> moves = new ArrayList<>();

        for (char charMove: movements.toCharArray()) {
            moves.add(getMovementsByChar(charMove));
        }

        return moves;
    }

    private Movement getMovementsByChar(char charMovement) {
        switch (charMovement){
            case 'M': return new AheadMovement();
            case 'L': return new TurnLeftMovement();
            case 'R': return new TurnRightMovement();
            default: throw new InvalidCommandException(""+charMovement);
        }
    }

    @Override
    public String print() {
        //TODO
        return String.format("(%s, %s, %s)",getXPosition(), getYPosition(),getOrientation());
    }
}
