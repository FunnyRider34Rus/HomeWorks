package Lesson9;


import java.util.Scanner;

public class Main {

    public static String[][] array = new String[4][4];

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] array = {
                {"1", "2", "3", "4"},
                {"4", "3", "2", "1"},
                {"9", "8", "7", "6"},
                {"5", "6", "7", "q"}/*,
                {"2", "3", "2", "1"}*/
        };

        printArr (array);

    }

    public static void printArr(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length > 4) {
            throw new MyArraySizeException("Превышен размер массива!");
        }

        int[][] arrayInt = new int[4][4];
        int sum = 0;

        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                try {
                    arrayInt[x][y] = Integer.parseInt(array[x][y]);
                    sum += arrayInt[x][y];
                } catch (NumberFormatException err) {
                    throw new MyArrayDataException("Элемент массива с индексом " + x + ", " + y + " имеет не числовой тип данных");
                }
            }
        }

        System.out.println(sum);

    }
}
