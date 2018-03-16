package com.github.marcospsbrito.mars.domain.movements;

import com.github.marcospsbrito.mars.domain.MarsRobot;
import com.github.marcospsbrito.mars.domain.Terrain;
import com.github.marcospsbrito.mars.exceptions.InvalidCommandException;
import com.github.marcospsbrito.mars.exceptions.InvalidPositionException;

/**
 * Created by marcos on 15/03/18.
 */
public class AheadMovement implements Movement {

    @Override
    public void doMovement(MarsRobot robot, Terrain terrain) throws InvalidCommandException, InvalidPositionException {
        switch (robot.getOrientation()){
            case E:addX(robot, 1);break;
            case W:addX(robot, -1);break;
            case N:addY(robot, 1);break;
            case S:addY(robot, -1);break;
        }

        boolean  invalidXPosition = robot.getXPosition()<0 || robot.getXPosition()>=terrain.getXLeght();
        boolean  invalidYPosition = robot.getYPosition()<0 || robot.getYPosition()>=terrain.getyLenght();

        if( invalidXPosition||invalidYPosition){
            throw new InvalidPositionException(robot.print());
        }
    }

    private void addY(MarsRobot robot, int i) {
        robot.setYPosition(robot.getYPosition()+i);
    }

    private void addX(MarsRobot robot, int i){
        robot.setXPosition(robot.getXPosition()+i);
    }
}
