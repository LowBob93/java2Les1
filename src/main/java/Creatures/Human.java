package Creatures;


import Obstacles.Treadmill;
import Obstacles.Wall;
import aAction.Contender;
import aAction.Obstacle;

import java.util.Random;

import java.util.Random;

public class Human implements Contender {

    private final String name;
    private final int jumpLimit;
    private final int runLimit;
    private boolean isItDone;

    public Human(String name) {
        this.name = name;
        this.jumpLimit = new Random().nextInt(8) + 2;
        this.runLimit = new Random().nextInt(10) + 5;
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
        return isItDone;
    }

    public void setFinished(boolean finished) {
        isItDone = finished;
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
                System.out.println("Человек  " + getName() + " не перепрыгнул препятствие");
                setFinished(false);
            } else {
                System.out.println("Человек  " + getName() + " перепрыгнул препятствие");
                setFinished(true);
            }
        } else {
            run();
            if (this.getMaxRun() < ((Treadmill) obstacle).getLength()) {
                System.out.println("Человек  " + getName() + "не пробежал дистанцию");
                setFinished(false);
            } else {
                System.out.println("Человек  " + getName() + " пробежал дистанцию");
                setFinished(true);
            }
        }
    }
}
