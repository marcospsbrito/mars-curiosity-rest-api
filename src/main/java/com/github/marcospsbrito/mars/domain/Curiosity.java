package com.github.marcospsbrito.mars.domain;

import com.github.marcospsbrito.mars.domain.movements.AheadMovement;
import com.github.marcospsbrito.mars.domain.movements.Movement;
import com.github.marcospsbrito.mars.domain.movements.TurnLeftMovement;
import com.github.marcospsbrito.mars.exceptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcos on 15/03/18.
 */
public class Curiosity extends MarsRobot{

    private Orientation orientation;

    @Override
    protected void init() {
        this.setxPosition(0);
        this.setyPosition(0);
    }

    @Override
    protected List<Movement> recognizeMovements(String movements) {
        if(!movements.toUpperCase().matches("[M|L|R]*")){
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
        return String.format("(s%, s%, s%)",getxPosition(),getyPosition(),getOrientation());
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
