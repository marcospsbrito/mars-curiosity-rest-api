package com.github.marcospsbrito.mars.domain.movements;

import com.github.marcospsbrito.mars.domain.MarsRobot;
import com.github.marcospsbrito.mars.domain.Orientation;
import com.github.marcospsbrito.mars.exceptions.InvalidCommandException;
import com.github.marcospsbrito.mars.exceptions.InvalidPositionExceprion;

/**
 * Created by marcos on 15/03/18.
 */
public class TurnLeftMovement implements Movement {
    @Override
    public void doMovement(MarsRobot robot) throws InvalidCommandException, InvalidPositionExceprion {
        switch (robot.getOrientation()){
            case S:robot.setOrientation(Orientation.E);
            case E:robot.setOrientation(Orientation.N);
            case N:robot.setOrientation(Orientation.W);
            case W:robot.setOrientation(Orientation.S);
            default:throw new InvalidCommandException("Turn Left");
        }
    }
}
