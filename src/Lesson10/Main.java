package Lesson10;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] array = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "восемь", "семь", "шесть", "пять"};

        System.out.print("Исходный массив: ");
        for (String item : array){
            System.out.print(item + ", ");
        }
        System.out.println();

        doFirstExample(array);

        doSecondExample();

    }

    public static void doFirstExample(String array[]){
        Set<String> array_temp = new HashSet<String>();

        for (String item : array){
            array_temp.add(item);
        }

        System.out.print("Выводим массив без повторяющихся элементов: ");
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

    public static void doSecondExample(){                                       //телефонный справочник
        Scanner scr = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        System.out.println();

        boolean exit = true;

        phoneBook.init();                                                       //создаём тестовую базу

        while (exit){
            System.out.println("Главное меню телефонного справочника:");
            System.out.println("1 - Вывести весь справочник");
            System.out.println("2 - Добавить новую запись");
            System.out.println("3 - Поиск по фамилии");
            System.out.println("4 - Выход");
            System.out.print("Введите номер пункта меню: ");
            int menu = scr.nextInt();
            switch (menu){
                case 1: phoneBook.printPB(); break;
                case 2:
                    phoneBook.addPhone(); break;
                case 3:
                    phoneBook.findByName(); break;
                default:
                    exit = false;
                    break;
            }

        }
    }
}

