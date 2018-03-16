package com.github.marcospsbrito.mars.domain.movements;

import com.github.marcospsbrito.mars.domain.MarsRobot;
import com.github.marcospsbrito.mars.domain.Orientation;
import com.github.marcospsbrito.mars.exceptions.InvalidCommandException;
import com.github.marcospsbrito.mars.exceptions.InvalidPositionExceprion;

/**
 * Created by marcos on 15/03/18.
 */
public class TurnRightMovement implements Movement {
    @Override
    public void doMovement(MarsRobot robot) throws InvalidCommandException, InvalidPositionExceprion {
        switch (robot.getOrientation()){
            case S:robot.setOrientation(Orientation.W);
            case E:robot.setOrientation(Orientation.S);
            case N:robot.setOrientation(Orientation.E);
            case W:robot.setOrientation(Orientation.N);
            default:throw new InvalidCommandException("Turn Left");
        }
    }
}
