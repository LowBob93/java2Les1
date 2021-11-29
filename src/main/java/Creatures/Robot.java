package Creatures;

import Obstacles.Treadmill;
import Obstacles.Wall;
import aAction.Contender;
import aAction.Obstacle;

import java.util.Random;

import java.util.Random;

public class Robot implements Contender {

    private final String name;
    private final int runLimit;
    private final int jumpLimit;
    private boolean isFinished;

    public Robot(String name) {
        this.name = name;
        this.runLimit = 10;
        this.jumpLimit = 10;
        // подумал что робот имеет Фиксированные ттх
    }

    public String getName() {
        return name;
    }

    public int getMaxRun() {
        return runLimit;
    }

    public int getMaxJump() {
        return jumpLimit;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public void jump() {
    }

    @Override
    public void run() {

    }

    @Override
    public void move(Obstacle obstacle) {
        if (obstacle instanceof Wall) {
            jump();
            if (this.getMaxJump() < ((Wall) obstacle).getHeight()) {
                System.out.println("Робот  " + getName() + " не перепрыгнул препятствие");
                setFinished(false);
            } else {
                System.out.println("Робот  " + getName() + " перепрыгнул препятствие");
                setFinished(true);
            }
        } else {
            run();
            if (this.getMaxRun() < ((Treadmill) obstacle).getLength()) {
                System.out.println("Робот  " + getName() + " не пробежал дистанцию");
                setFinished(false);
            } else {
                System.out.println("Робот  " + getName() + " пробежал дистанцию");
                setFinished(true);
            }
        }
    }
}