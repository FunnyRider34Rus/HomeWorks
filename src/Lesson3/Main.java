package Lesson3;

import java.util.Random;
import java.util.Scanner;

public  class Main {

    public static void main(String[] args) {
        theGame();
    }

    public static boolean theGame(){
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        int targetNum = rnd.nextInt(9);
        for (int i = 3; i > 0; i--) {
            System.out.println("Загадано случайное число от 0 до 9. У вас есть: " + i + " попыток");
            System.out.println("Введите предполагаемое число: ");
            int answer = scan.nextInt();
            if (answer == targetNum) return true;
        }
        return false;
    }

    void gameLauncher(boolean endGame) {
        if (endGame) {
            System.out.println("Поздравляю! Вы отгадали число!");
        } else {
            System.out.println("К сожалению, Вы не угадали!");
        }
        int d = getNumberFromScanner("Повторить игру еще раз? (1 - Да, 0 - Нет", 0, 1);
        if (d == 1) theGame();
        }

    public int getNumberFromScanner(String message, int min, int max) {
        Scanner scan = new Scanner(System.in);
        int x;
        do {
            System.out.println(message);
            x = scan.nextInt();
        } while (x == 0 || x == 1);
        return x;
    }

}