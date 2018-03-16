package com.github.marcospsbrito.mars.domain.movements;

import com.github.marcospsbrito.mars.domain.MarsRobot;
import com.github.marcospsbrito.mars.domain.Orientation;
import com.github.marcospsbrito.mars.domain.Terrain;
import com.github.marcospsbrito.mars.exceptions.InvalidCommandException;
import com.github.marcospsbrito.mars.exceptions.InvalidPositionException;

/**
 * Created by marcos on 15/03/18.
 */
public class TurnLeftMovement implements Movement {
    @Override
    public void doMovement(MarsRobot robot, Terrain terrain) throws InvalidCommandException, InvalidPositionException {
        switch (robot.getOrientation()){
            case S:robot.setOrientation(Orientation.E);break;
            case E:robot.setOrientation(Orientation.N);break;
            case N:robot.setOrientation(Orientation.W);break;
            case W:robot.setOrientation(Orientation.S);break;
            default:throw new InvalidCommandException("Turn Left");
        }
    }
}
