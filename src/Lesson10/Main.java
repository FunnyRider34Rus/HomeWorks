package Lesson10;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] array = {
                "ноль",
                "один",
                "два",
                "три",
                "четыре",
                "пять",
                "шесть",
                "семь",
                "восемь",
                "девять",
                "восемь",
                "семь",
                "шесть",
                "пять"
        };

        doFirstExample(array);

    }

    public static void doFirstExample(String array[]){
            Set<String> array_temp = new HashSet<String>();

            for (String item : array){
                array_temp.add(item);
            }

            System.out.println(array_temp);

            HashMap<String, Integer> array_final = new HashMap<>();
            for (String item : array_temp) {
                int number = 0;
                for (int i = 0; i < array.length; i++) {
                    if (item.equals(array[i])){
                        number++;
                    }
                    array_final.put(item, number);
                }
            }

            for (Map.Entry<String, Integer> o : array_final.entrySet()) {
                System.out.println(o.getKey() + " содержится в количестве " + o.getValue());
            }
    }
}

