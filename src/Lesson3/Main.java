package Lesson3;

import java.util.Random;
import java.util.Scanner;

public  class Main {

    public static void main(String[] args) {
        theGame();
        guessGame();
    }

    static void theGame(){
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Загадано случайное число от 0 до 9");

        int targetNum = rnd.nextInt(9);
        for (int i = 3; i > 0; i--) {
            System.out.println("У вас осталось: " + i + " попытки(а)");
            System.out.print("Введите предполагаемое число: ");
            int answer = scan.nextInt();
            if (answer > targetNum) {
                System.out.println("Не угадали! Загаданное число меньше");
            } else if (answer < targetNum){
                System.out.println("Не угадали! Загаданное число больше");
            } else {
                System.out.println("Поздравляю! Вы угадали!!!");
                break;
            }
        }
        System.out.println("Повторить игру еще раз? (1 - Да, 0 - Нет)");
        int d = scan.nextInt();
        if (d == 1) {
            theGame();
        }
    }

    static void guessGame() {
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int targetWordNum = rnd.nextInt(words.length);
        char[] tempArray = new char[15];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray [i] = '#';
        }

        System.out.println("Загадано слово из следующего списка:");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words [i] + " ");
        }

        System.out.println("Ваша задача угадать загаданное слово!");
        boolean equal;
        System.out.println(words[targetWordNum]);
        do {
            System.out.print("\nВведите предполагаемое слово:");
            String answer = scan.nextLine();
            equal = words[targetWordNum].equalsIgnoreCase(answer);
            if (equal) {} else {
                for (int i = 0; i < answer.length() && i < words[targetWordNum].length(); i++) {
                    char a = answer.charAt(i);
                    char b = words[targetWordNum].charAt(i);
                    if (a == b) tempArray [i] = a;
                }
                for (char o : tempArray) {
                    System.out.print(o);
                }
            }
        } while (!equal);
        System.out.println();
        System.out.println("Поздравляю! Вы угадали слово!");
    }
}