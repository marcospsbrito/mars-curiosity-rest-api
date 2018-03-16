package com.github.marcospsbrito.mars;

import com.github.marcospsbrito.mars.domain.Curiosity;
import com.github.marcospsbrito.mars.domain.MarsRobot;
import com.github.marcospsbrito.mars.domain.Terrain;
import com.github.marcospsbrito.mars.exceptions.InvalidCommandException;
import com.github.marcospsbrito.mars.exceptions.InvalidPositionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcos on 15/03/18.
 */

@RestController
@RequestMapping("/rest")
public class CuriosityController{

    @Autowired
    private CuriosityService curiosityService;

    @GetMapping("/mars")
    public ResponseEntity getDefaultCuriosityPosition(){
        try{
            MarsRobot robot = new Curiosity();
            return new ResponseEntity<>(robot.print(),HttpStatus.OK);
        }catch (InvalidCommandException |InvalidPositionException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/mars/{movements}")
    public ResponseEntity moveCuriosity(@PathVariable() String movements){
        try{
            MarsRobot robot = new Curiosity();
            Terrain terrain = new Terrain(5,5);
            curiosityService.moveRobot(robot,terrain,movements);
            return new ResponseEntity<>(robot.print(),HttpStatus.OK);
        }catch (InvalidCommandException |InvalidPositionException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
}
