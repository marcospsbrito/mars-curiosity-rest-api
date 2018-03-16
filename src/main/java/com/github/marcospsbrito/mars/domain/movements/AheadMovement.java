package com.github.marcospsbrito.mars.domain.movements;

import com.github.marcospsbrito.mars.domain.MarsRobot;
import com.github.marcospsbrito.mars.domain.Orientation;
import com.github.marcospsbrito.mars.exceptions.InvalidCommandException;
import com.github.marcospsbrito.mars.exceptions.InvalidPositionExceprion;

/**
 * Created by marcos on 15/03/18.
 */
public class AheadMovement implements Movement {

    @Override
    public void doMovement(MarsRobot robot) throws InvalidCommandException, InvalidPositionExceprion {
        switch (robot.getOrientation()){
            case E:addX(robot, 1);
            case W:addX(robot, -1);
            case N:addY(robot, 1);
            case S:addY(robot, -1);
        }
        if(robot.getxPosition()>=robot.getTerrain().getXLeght() ||
                robot.getyPosition()>=robot.getTerrain().getyLenght()){
            throw new InvalidPositionExceprion(robot.print());
        }
    }

    private void addY(MarsRobot robot, int i) {
        robot.setxPosition(robot.getyPosition()+i);
    }

    private void addX(MarsRobot robot, int i){
        robot.setxPosition(robot.getxPosition()+i);
    }
}
