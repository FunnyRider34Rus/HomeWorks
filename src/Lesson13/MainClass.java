package Lesson13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        Race race = new Race(new Road(60), new Tunnel(20), new Road(40));
        for (int i = 0; i < CARS_COUNT; i++) {
            cars.add(new Car(race, 20 + (int) (Math.random() * 10), countDownLatch));
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        for (int i = 0; i < cars.size(); i++) {
            threads.add(new Thread(cars.get(i)));
            threads.get(i).start();
        }
        try {
            countDownLatch.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            for (int i = 0; i < threads.size(); i++) {
                threads.get(i).join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

    }

}
