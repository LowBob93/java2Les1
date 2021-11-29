package Creatures;
import Obstacles.Treadmill;
import Obstacles.Wall;
import aAction.Contender;
import aAction.Obstacle;

import java.util.Random;

public class Cat implements Contender {

    private final String name;
    private final int runLimit;
    private final int jumpLimit;
    private boolean isItDone;

    public Cat(String name) {
        this.name = name;
        this.jumpLimit = new Random().nextInt(12) + 4;
        this.runLimit = new Random().nextInt(7) + 3;
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
                System.out.println("Кот  " + getName() + " не перепрыгнул препятствие");
                setFinished(false);
            } else {
                System.out.println("Кот  " + getName() + " перепрыгнул препятствие");
                setFinished(true);
            }
        } else {
            run();
            if (this.getMaxRun() < ((Treadmill) obstacle).getLength()) {
                System.out.println("Кот  " + getName() + " не пробежал дистанцию");
                setFinished(false);
            } else {
                System.out.println("Кот  " + getName() + " пробежал дистанцию");
                setFinished(true);
            }
        }
    }
}