package Lesson8.Equipment;

import Lesson8.Participant.Participant;

public class Treadmill implements Equipment {
    private int Length;

    public Treadmill(int length) {
        Length = length;
    }

    @Override
    public void startCompetition(Participant participant) {
        //return false;
    }
}
