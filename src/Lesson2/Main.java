package Lesson2;

public class Main {

    public static void main(String[] args) {

        int[] mass1 = {1, 0, 1, 1, 0, 1, 0, 0}; //Инициализируем и присваиваем значения массиву из целочисленных чисел
        example1(mass1); //Вызываем метод и передаём в него массив

        example2(); //Вызываем метод выполнения 2го задания

        int[] mass3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; //Инициализируем и присваиваем значения массиву из целочисленных чисел
        example3(mass3); //Вызываем метод выполнения 3го задания

        int[][] mass4 = new int[4] [4]; //Инициализация многомерного массива из целочисленный чисел
        example4(mass4); //Вызов метода для реализации требований 4го задания

        example5(); //Вызов метода для решения 5го задания

        //Решаем 6ое задание
        int[] mass6 = {2, 2, 2, 1, 2, 2, 10, 1};
        boolean isTrue = example6(mass6); //Вызов метода для решения 6го задания
        System.out.print("\n\nЗадание №6. Массив: ");
        for (int x = 0; x < mass6.length; x++){
            System.out.print(mass6[x] + "\t");
        }
        if (isTrue){
            System.out.println(" в своем составе имеет одинаковую сумму левой и правой части");
        } else {
            System.out.println(" в своем составе не имеет одинаковую сумму левой и правой части");
        }

        //Пробем что-нибудь накуралесить с 7м заданием! А в друг заведется)))
        int [] mass7 = {3, 5, 6, 1};
        int n = -2;
        //Понеслось!
        example7 (mass7, n);
        //Чуть не сдох, но этот говнокод работает!
    }

    public static void example1(int[] mass1) {

        //Выводим массив в консоль
        System.out.print("Исходный массив: ");
        for (int i = 0; i < mass1.length; i++) {
            System.out.print(mass1[i]);
        }

        //Модифицируем массив
        for (int i = 0; i < mass1.length; i++) {
            if (mass1[i] == 0) {
                mass1[i] = 1;
            } else {
                mass1[i] = 0;
            }
        }

        //Это для читабельности вывода консоли)))
        System.out.println();

        //Выводим модифицированный массив для проверки результата
        System.out.print("Преобразованный массив: ");
        for (int i=0; i < mass1.length; i++) {
            System.out.print(mass1[i]);
        }
    }

    public static void example2 (){

        //Инициализируем массив и выделяем для него память
        int[] mass2 = new int [8];
        int step = 0; //вспомогательная переменная типа integer

        //Заполняем массив значениями согласно алгоритму
        for (int i = 0; i < mass2.length; i++){
            mass2[i] = step;
            step += 3;
        }

        //Это для читабельности вывода консоли)))
        System.out.println();
        System.out.print("Массив соотвествующий требованиям 2го задания: ");

        //Выводим массив в консоль
        for (int a = 0; a < mass2.length; a++) {
            System.out.print(mass2[a] +" ");
        }
    }

    public static void example3 (int[] mass3){

        //Вывод заданного массива в консоль
        System.out.println();
        System.out.print("Исходный массив 3го задания: ");
        for (int i = 0; i < mass3.length; i++) {
            System.out.print(mass3[i] + " ");
        }

        //Производим модификацию массива в соответствии с заданием №3
        for (int i = 0; i < mass3.length; i++) {
            if (mass3[i] < 6) mass3[i] *= 2;
        }

        //Вывод модифицированного массива в консоль
        System.out.println();
        System.out.print("Модифицированный массив 3го задания: ");
        for (int i = 0; i < mass3.length; i++) {
            System.out.print(mass3[i] + " ");
        }
    }

    public static void example4 (int[][] mass4){

        //Заполняем диагональ единицами
        for (int x = 0; x < mass4.length; x++) {
            mass4[x][x] = 1;
        }

        int i = 0;
        for (int y = mass4.length - 1; y >= 0; y--){
            mass4[i][y] = 1;
            i++;
        }

        //Подгатовка вывода)))
        System.out.println("\n\nЗадание №4");

        //Вывод матрицы в консоль
        System.out.println();
        for (int x = 0; x < mass4.length; x++){
            for (int y = 0; y < mass4.length; y++){
                System.out.print(mass4[x][y] + "\t");
            }
            System.out.println();
        }
    }

    public static void example5 (){
        int[] mass5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int maxValue = mass5 [0], minValue = mass5 [0];
        for (int i = 0; i < mass5.length; i++){
            if (mass5[i] >= maxValue) maxValue = mass5[i];
            if (mass5[i] <= minValue) minValue = mass5[i];
        }

        //Вывод результатов
        System.out.println();
        System.out.print("Исходный массив 5го задания: ");
        for (int i = 0; i < mass5.length; i++) {
            System.out.print(mass5[i] + " ");
        }
        System.out.println();
        System.out.print("Минимальное значение в массиве: " + minValue + "; Максимальное значение в массиве: " + maxValue);
    }

    public static boolean example6 (int[] mass6) {//Метод сравнения элементов массива левой и правой части на равенство
        int lSum = 0, rSum = 0, y = mass6.length;
        for (int x = 0; x < mass6.length && x != y; x++){
            lSum += mass6[x];
            rSum = 0;
            for (int y1 = mass6.length - 1; y1 > x; y1--){
                rSum += mass6[y1];
                //System.out.println("\n" + lSum + " " + rSum);
            }
            //System.out.println("\n" + lSum + " " + rSum);
            if (lSum == rSum) return true;
        } return false;
    }

    public static void example7 (int mass7[], int n){
        //Даже комментировать не буду, башка уже не варит, сломал весь мозг
        if (n < 0){
            onLeft (mass7, n);
        } else {
            onRight (mass7, n);
        }

    }

    public static void onLeft (int mass7[], int n){
        System.out.println("\nЗадание №7");
        System.out.print("Исходный массив: ");
        for (int i = 0; i < mass7.length; i++) System.out.print(mass7[i]);
        for (int i = 0; i > n; i--){
            int bufferNum = mass7[0];
            for (int a = 0; a < mass7.length - 1; a++){
                mass7[a] = mass7 [a+1];
            }
            mass7[mass7.length - 1] = bufferNum;
        }
        System.out.print("\nМассив со сдвигом: ");
        for (int i = 0; i < mass7.length; i++) System.out.print(mass7[i]);
    }

    public static void onRight (int mass7[], int n){
        for (int i = 0; i < n; i++){
            int bufferNum = mass7[mass7.length - 1];
            for (int a = mass7.length - 2; a >= 0; a--){
                mass7[a+1] = mass7 [a];
            }
            mass7[0] = bufferNum;
        }
        System.out.print("\nМассив со сдвигом: ");
        for (int i = 0; i < mass7.length; i++) System.out.print(mass7[i]);
    }

}
