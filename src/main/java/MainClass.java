import Creatures.Cat;
import Creatures.Human;
import Creatures.Robot;
import Creatures.Team;
import Obstacles.Course;
import Obstacles.Treadmill;
import Obstacles.Wall;
import aAction.Contender;
import aAction.Obstacle;

public class MainClass {


    public static void main(String[] args) {

        Contender[] contendersArray = new Contender[4]; // массив участников

        contendersArray[0] = new Human("Тоби");
        contendersArray[1] = new Cat("Барсик");
        contendersArray[2] = new Cat("Томас");
        contendersArray[3] = new Robot("РХ-3021");

        Obstacle[] barrier = new Obstacle[3]; //массив препятствий
        barrier[0]= new Wall();
        barrier[1] = new Treadmill();
        barrier[2] = new Wall();

        passTheObstacles(contendersArray, barrier);

        Course course = new Course(barrier);
        Team team = new Team("Джависты",new Cat("Локи"), new Human("Томми Версети "), new Human("Карл Джонс"), new Robot("РХ-6600ХТ")); // обьявляем команду участников
        team .printTeamInfo();
        course.doIt(team);
        team.showResults();


    }

    public static void passTheObstacles(Contender[] team, Obstacle[] barriers) { // метод прохождения препятствий существами
        System.out.println("___________");
        System.out.println("Участники на полосе препядствий!");
        for (Contender contender : team) {
            for (Obstacle barrier : barriers) {
                if (contender instanceof Human) {
                    ((Human) contender).setFinished(true);
                    ((Human) contender).move(barrier);
                    if (!((Human) contender).isFinished()) {
                        break;
                    }
                } else if (contender instanceof Cat) {
                    ((Cat) contender).setFinished(true);
                    ((Cat) contender).move(barrier);
                    if (!((Cat) contender).isFinished()) {
                        break;
                    }
                } else if (contender instanceof Robot) {
                    ((Robot) contender).setFinished(true);
                    ((Robot) contender).move(barrier);
                    if (!((Robot) contender).isFinished()) {
                        break;
                    }
                }
            }
        }
        System.out.println("___________");
        System.out.println("Финиш!");
    }
}