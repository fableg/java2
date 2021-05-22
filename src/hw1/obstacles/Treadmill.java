package hw1.obstacles;

import hw1.participants.Participant;

public class Treadmill implements Obstacle{

    private final int lenght;

    public Treadmill(int length) {
        this.lenght = length;
    }


    @Override
    public boolean passObstacleBy(Participant participant) {
        if (participant.run() >= lenght) {
            System.out.println("Участик " + participant + " успешно пробежвл дистанцию");
        return true;
    } else {
            System.out.println("Участник " + participant + " не смог пробежать дистанцию " + lenght);
            return false;
        }
    }
}
