package com.github.marcospsbrito.mars.domain;

import com.github.marcospsbrito.mars.domain.movements.Movement;

import java.util.List;

/**
 * Created by marcos on 15/03/18.
 */
public abstract class MarsRobot {
    private Orientation orientation;
    private int xPosition;
    private int yPosition;
    private List<Movement> movements;

    public MarsRobot(){
        init();    
    }

    protected abstract void init();

    public void move(Terrain terrain, String movements){
        this.setMovements(recognizeMovements(movements));
        for (Movement move: this.movements) {
            move.doMovement(this,terrain);
        }
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    protected abstract List<Movement> recognizeMovements(String movements);

    public abstract String print();

}
