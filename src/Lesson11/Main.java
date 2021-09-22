package Lesson11;

import Lesson11.Fruit.Warehouse;
import java.util.*;

/*хоть и сдаю позже, чем был разбор этого дз
но все равно старался все сделать сам. Единственное, что использовал <?>
однако, если бы писал не в IDEA, то без её подсказок - было бы реально тяжело!
задание интересное, но нужно еще практиковаться, потому что чувствую
что еще не до конца понял принципы применения обобщений.
 */

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

        Warehouse.run();                                                                                                //запускаем 11.3

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
