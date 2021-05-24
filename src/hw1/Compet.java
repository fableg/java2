package hw1;

import hw1.obstacles.Obstacle;
import hw1.participants.Participant;

import java.util.LinkedList;
import java.util.List;

public class Compet {

    private Obstacle[] obstacles;
    private Participant[] participants;
    private final String competTitle;

    private List<Participant> lastWinners = new LinkedList<>();

    public Compet(String competTitle) {
        this.competTitle = competTitle;
    }

    public void setObstacles(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void setParticipants(Participant... participants) {
        this.participants = participants;
    }

    public void startCompetition() {
        System.out.println("Начало соревнования " + competTitle);
        lastWinners.clear();

        for (Participant participant : participants) {
            boolean success = passAllObstacles(participant);
            if (!success) {
                System.out.println("Участник " + participant + " покинул испытание");
            } else {
                lastWinners.add(participant);
            }
        }
    }

    public List<Participant> getLastWinners() {
        return lastWinners;
    }

    private boolean passAllObstacles(Participant participant) {
        for (Obstacle obstacle : obstacles) {
            if ( !participant.passObstacle(obstacle) ) {
                return false;
            }
            System.out.println();
        }
        return true;
    }


}
