package Lesson3;

import java.util.Random;
import java.util.Scanner;

public  class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        System.out.println("Загадано случайное число от 0 до 9");
        theGame();
        System.out.println("Повторить игру еще раз? (1 - Да, 0 - Нет)");
        int d = scan.nextInt();
        if (d == 1) {
            theGame();
        }
    }

    static void theGame(){
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        int targetNum = rnd.nextInt(9);
        for (int i = 3; i > 0; i--) {
            System.out.println(targetNum);
            System.out.println("У вас осталось: " + i + " попытки(а)");
            System.out.print("Введите предполагаемое число: ");
            int answer = scan.nextInt();
            if (answer > targetNum) {
                System.out.println("Не угадали! Загаданное число меньше");
            } else if (answer < targetNum){
                System.out.println("Не угадали! Загаданное число больше");
            } else {
                System.out.println("Поздавляю! Вы угадали!!!");
                break;
            }
        }
    }
}