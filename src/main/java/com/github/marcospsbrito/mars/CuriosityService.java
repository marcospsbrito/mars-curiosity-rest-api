package com.github.marcospsbrito.mars;

import com.github.marcospsbrito.mars.domain.MarsRobot;
import com.github.marcospsbrito.mars.domain.Terrain;

/**
 * Created by marcos on 15/03/18.
 */
public class CuriosityService {
    public MarsRobot moveRobot(MarsRobot robot, Terrain terrain, String movements){
        robot.move(terrain, movements);
        return robot;
    }
}
