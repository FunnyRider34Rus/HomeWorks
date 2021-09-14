package Lesson11;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        Object[] array = {"1", "q", 1.5f, 10L, "5"};                                                                    //создаем массив содержащий ссылочны типы данных
        System.out.print("Исходный массив: ");

        for (Object x : array) {
            System.out.print(x + " ");
        }

        System.out.println();                                                                                           //запрашиваем у пользователя индексы данных для корректировки массива
        System.out.print("Введите номер элемента массива, от 1 до " + array.length + ", который нужно переместить: ");
        int fistIndex = scr.nextInt() - 1;
        System.out.print("Введите номер элемента массива, от 1 до " + array.length + ",куда нужно переместить: ");
        int secondIndex = scr.nextInt() - 1;

        System.out.print("Модифицированный массив: ");
        System.out.println(toArrayList(exchangeData(array, fistIndex, secondIndex)));                                   //производим изменение массива и преобразуем его в ArrayList с одновременным выводом

    }

    public static <T> T[] exchangeData(T[] array, int firstIndex, int secondIndex){                                     //метод модификации массива

        T buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;

        return array;
    }

    public static <T> ArrayList<T> toArrayList(T[] array){                                                              //создаем ArrayList, который ссылается на массив
        return new ArrayList<>(Arrays.asList(array));
    }
}
