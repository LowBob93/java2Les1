package Obstacles;




import aAction.Obstacle;

import java.util.Random;

public class Wall implements Obstacle {

    private final int height;

    public Wall() {
        this.height = new Random().nextInt(7) + 2;
    }

    public int getHeight() {
        return height;
    }
}