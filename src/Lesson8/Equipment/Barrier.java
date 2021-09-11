package Lesson8.Equipment;

import Lesson8.Participant.Participant;

public class Barrier implements Equipment {
    private double Height;

    public Barrier(double height) {
        Height = height;
    }

    @Override
    public void startCompetition(Participant participant) {
        System.out.println("Участник пробует пройти следующее испытание: барьер высотой " + Height);
        participant.jumping(Height);
    }
}
