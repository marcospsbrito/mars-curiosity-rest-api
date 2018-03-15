package com.github.marcospsbrito.mars.domain;

/**
 * Created by marcos on 15/03/18.
 */
public class Terrain {
    private int xLeght,yLenght;

    public Terrain(int xLeght, int yLenght){
        this.xLeght = xLeght;
        this.yLenght = yLenght;
    }

    public int getXLeght() {
        return xLeght;
    }

    public void setXLeght(int xLeght) {
        this.xLeght = xLeght;
    }

    public int getyLenght() {
        return yLenght;
    }

    public void setyLenght(int yLenght) {
        this.yLenght = yLenght;
    }
}
