package Lesson11;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        doFirstExample();

    }

    static void doFirstExample(){
        Scanner scr = new Scanner(System.in);
        String[] array = {"1", "2", "3", "4", "5"};
        System.out.print("Исходный массив: ");

        for (String x : array){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("Введите номер элемента массива, от 1 до " + array.length + ", который нужно переместить: ");
        int bufferIndex = scr.nextInt() - 1;
        System.out.print("Введите номер элемента массива, от 1 до " + array.length + ",куда нужно переместить: ");
        int bufferIndex2 = scr.nextInt() - 1;
        String bufferNum = array[bufferIndex2];
        array[bufferIndex2] = array[bufferIndex];
        array[bufferIndex] = bufferNum;
        System.out.println();
        System.out.print("Измененный массив: ");

        for (String x : array){
            System.out.print(x + " ");
        }
    }
}
