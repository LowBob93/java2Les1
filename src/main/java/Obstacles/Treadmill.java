package Obstacles;

import aAction.Obstacle;

import java.util.Random;

public class Treadmill implements Obstacle {

    private final int size;

    public Treadmill() {
        this.size = new Random().nextInt(6) + 5;
    }

    public int getLength() {
        return size;
    }
}