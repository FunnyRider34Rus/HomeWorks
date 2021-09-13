package Lesson10;

import java.util.Scanner;
import java.util.*;

public class PhoneBook {
    private
    Scanner scr = new Scanner(System.in);
    HashMap<String, String> phoneBook = new HashMap<>();

    public void init(){
        phoneBook.put("+123", "Иванов");
        phoneBook.put("+132", "Петров");
        phoneBook.put("+321", "Сидоров");
        phoneBook.put("+1", "Иванов");
    }

    public void addPhone(){
        System.out.print("Введите фамилию: ");
        String values = scr.nextLine();
        System.out.print("Введите номер телефона: ");
        String key = scr.nextLine();
        phoneBook.put(key, values);
    }

    public void printPB(){
        for (Map.Entry<String, String> o : phoneBook.entrySet()) {
            System.out.println(o.getValue() + ": " + o.getKey()); }
        }

    public void findByName(){
        System.out.print("Введите фамилию: ");
        String nameForFind = scr.nextLine();
        for (Map.Entry<String, String> o : phoneBook.entrySet()) {
            if (o.getValue().equals(nameForFind)){
                System.out.println(o.getKey());
            }
        }
    }
}
