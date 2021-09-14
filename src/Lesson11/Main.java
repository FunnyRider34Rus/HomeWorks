package Lesson11;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        Object[] array = {"1", "2", "3", "4", "5"};
        System.out.print("Исходный массив: ");

        for (Object x : array) {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.print("Введите номер элемента массива, от 1 до " + array.length + ", который нужно переместить: ");
        int fistIndex = scr.nextInt() - 1;
        System.out.print("Введите номер элемента массива, от 1 до " + array.length + ",куда нужно переместить: ");
        int secondIndex = scr.nextInt() - 1;

        System.out.print("Модифицированный массив: ");
        System.out.println(toArrayList(exchangeData(array, fistIndex, secondIndex)));

    }

    public static <T> T[] exchangeData(T[] array, int firstIndex, int secondIndex){

        T buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;

        return array;
    }

    public static <T> ArrayList<T> toArrayList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
