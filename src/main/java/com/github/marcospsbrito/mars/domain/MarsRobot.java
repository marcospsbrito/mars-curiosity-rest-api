package com.github.marcospsbrito.mars.domain;

import com.github.marcospsbrito.mars.domain.movements.Movement;

import java.util.List;

/**
 * Created by marcos on 15/03/18.
 */
public abstract class MarsRobot {
    private int xPosition;
    private int yPosition;
    private Terrain terrain;
    private List<Movement> movements;

    public MarsRobot(){
        init();    
    }

    protected abstract void init();

    public void move(Terrain terrain, String movements){
        this.setMovements(recognizeMovements(movements));
        for (Movement move: this.movements) {
            move.doMovement(this);
        }
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public List<Movement> getMoviments() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    protected abstract List<Movement> recognizeMovements(String movements);

    public abstract String print();
}
