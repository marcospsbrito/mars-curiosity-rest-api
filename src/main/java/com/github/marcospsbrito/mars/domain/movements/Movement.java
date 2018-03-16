package com.github.marcospsbrito.mars.domain.movements;

import com.github.marcospsbrito.mars.domain.MarsRobot;
import com.github.marcospsbrito.mars.domain.Terrain;
import com.github.marcospsbrito.mars.exceptions.InvalidCommandException;
import com.github.marcospsbrito.mars.exceptions.InvalidPositionException;

/**
 * Created by marcos on 15/03/18.
 */
public interface Movement {
    void doMovement(MarsRobot robot, Terrain terrain) throws InvalidCommandException,InvalidPositionException;
}
