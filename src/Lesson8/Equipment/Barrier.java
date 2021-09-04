package Lesson8.Equipment;

import Lesson8.Participant.Participant;

public class Barrier implements Equipment {
    private double Height;

    public Barrier(double height) {
        Height = height;
    }

    @Override
    public void startCompetition(Participant participant) {
        //return false;
    }
}
