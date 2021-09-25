package Lesson13;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int numCar;
    private final Race race;
    private final int speed;
    private final String name;
    private final CountDownLatch countDownLatch;
    private static boolean winner = false;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch cdl) {
        this.race = race;
        this.speed = speed;
        numCar++;
        this.name = "Участник #" + numCar;
        this.countDownLatch = cdl;
    }


    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            countDownLatch.countDown();
            countDownLatch.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            checkWinner(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static synchronized void checkWinner(Car car) {
        if (!winner) {
            System.out.println(car.name + " - WIN");
            winner = true;
        } else {
            System.out.println(car.name + " закончил гонку!");
        }
    }
}
