package hw1;

import hw1.obstacles.Treadmill;
import hw1.obstacles.Wall;
import hw1.participants.Cat;
import hw1.participants.Human;
import hw1.participants.Participant;
import hw1.participants.Robot;

import java.util.Random;

public class CompetTest {
    public static void main(String[] args) {
        System.out.println("Подготовительный этап...");
        Compet compet = createAndPrepareCompet();

        System.out.println("Начинаем соревнование");
        compet.startCompetition();

        System.out.println("Соревнование окончиено. Победители: ");
        for (Participant winner : compet.getLastWinners()) {
            System.out.println(winner);
        }
    }

    private static Compet createAndPrepareCompet() {
        Participant human = new Human("Arthur", 150,250);
        Participant cat = new Cat("Toshka", 500, 560);
        Participant robot = new Robot("TERMINATOR", 200,600);

        Random random = new Random();

        Wall wall = new Wall(random.nextInt(500));
        Treadmill treadmill = new Treadmill(random.nextInt(600));

        Compet compet = new Compet("Multiverse sport contest");
        compet.setParticipants(human,cat,robot);
        compet.setObstacles(wall, treadmill);
        return compet;


    }

}
