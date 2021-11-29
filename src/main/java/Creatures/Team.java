package Creatures;

import aAction.Contender;

public class Team {

    private final String teamName;
    private final Contender[] teamArray;
    private int winPoints;

    public Team(String teamName, Contender teamMate1, Contender teamMate2, Contender teamMate3, Contender teamMate4) {
        this.teamName = teamName;
        this.teamArray = new Contender[4];
        teamArray[0] = teamMate1;
        teamArray[1] = teamMate2;
        teamArray[2] = teamMate3;
        teamArray[3] = teamMate4;
    }

    public String getTeamName() {

        return teamName;
    }

    public Contender[] getTeamArray() {

        return teamArray;
    }

    public int getWinPoints() {
        return winPoints;
    }

    public void setWinPoints(int winPoints) {
        this.winPoints = winPoints;
    }

    public void printTeamInfo() {
        System.out.println("______________________");
        System.out.println("Обявляем участников :");
        System.out.println("Команда  " + getTeamName() + ":");
        System.out.println("Участники:");
        for (Contender contender : teamArray) {
            if (contender instanceof Human) {
                System.out.println("Человек " + ((Human) contender).getName() + " Высота прыжка  " + ((Human) contender).getMaxJump() + " Выносливость " + ((Human) contender).getMaxRun());
            } else if (contender instanceof Cat) {
                System.out.println("Кот " + ((Cat) contender).getName() + " Высота прыжка  " + ((Cat) contender).getMaxJump()  +  " Выносливость " + ((Cat) contender).getMaxRun());
            } else if (contender instanceof Robot) {
                System.out.println("Робот " + ((Robot) contender).getName() + " Высота прыжка  " + ((Robot) contender).getMaxJump() + " Выносливость " + ((Robot) contender).getMaxRun());
            }
        }
    }

    public void showResults() {
        if (winPoints < 1) {
            System.out.println("Команда " + teamName + " не смогла пройти испытание");
        } else {
            System.out.println("Победители: ");
            for (int i = 0; i < teamArray.length; i++) {
                if (teamArray[i] instanceof Human) {
                    if (((Human) teamArray[i]).isFinished()) {
                        System.out.println("Человек " + ((Human) teamArray[i]).getName());
                    }
                } else if (teamArray[i] instanceof Cat) {
                    if (((Cat) teamArray[i]).isFinished()) {
                        System.out.println("Кот " + ((Cat) teamArray[i]).getName());
                    }
                } else if (teamArray[i] instanceof Robot) {
                    if (((Robot) teamArray[i]).isFinished()) {
                        System.out.println("Робот " + ((Robot) teamArray[i]).getName());
                    }
                }
            }
        }
    }
}