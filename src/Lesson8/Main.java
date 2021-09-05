package Lesson8;

import Lesson8.Equipment.Equipment;
import Lesson8.Equipment.Treadmill;
import Lesson8.Equipment.Barrier;
import Lesson8.Participant.Participant;
import Lesson8.Participant.Human;
import Lesson8.Participant.Cat;
import Lesson8.Participant.Robot;

public class Main {
    public static void main(String[] args) {

        Participant[] participants = {
                new Human ("Человек", 1000, 1.2),
                new Cat ("Кот", 800, 1.5),
                new Robot ("Робот", 2000, 0)
        };

        Equipment[] equipments = {
                new Treadmill(1000),
                new Barrier(1),
                new Treadmill(1500)
        };

        for (Participant participant : participants) {
            for (Equipment equipment : equipments) {
                equipment.startCompetition(participant);
            }
            System.out.println();
        }
    }
}
