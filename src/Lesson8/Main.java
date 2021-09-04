package Lesson8;

import Lesson8.Equipment.Equipment;
import Lesson8.Equipment.Treadmill;
import Lesson8.Equipment.Barrier;
import Lesson8.Participants.Participants;
import Lesson8.Participants.Human;
import Lesson8.Participants.Cat;
import Lesson8.Participants.Robot;

public class Main {
    public static void main(String[] args) {

        Participants[] participants = {
                new Human ("Человек", 1000, 1.2),
                new Cat ("Кот", 800, 1.5),
                new Robot ("Робот", 2000, 0)
        };

        Equipment[] equipment = {
                new Treadmill(1000),
                new Barrier(1),
                new Treadmill(1500)
        };
    }
}
