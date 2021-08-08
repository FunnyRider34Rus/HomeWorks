package Lessons1;

public class Main {

    public static void main(String[] args) {

        // инициализируем примитивные типы данных и присваиваем им значения
        // целочисленные переменные
        byte numByte = 111;
        short numShort = 777;
        int numInt = 1024;
        long numLong = 10247;
        char numChar = 'Q';

        //инициализируем переменные с плавающей запятой
        float numFloat = 127.12F;
        double numDouble = 1027.127;

        //инициализируем строковый тип данных (массив символов)
        String str1 = "Massive of strings";

        //инициализируем логический тип данных
        boolean isTrue = true;

        //Вызываем метод вычисления выражения calcExp
        float result1 = calcExp(1.5F, 2.1F, 3.3F, 4.2F);
        System.out.println (result1);

        //Вызываем метод проверки суммы чисел на соответствие диапазону от 10 до 20 (включительно)
        int firstNum = 6, secondNum = 9;
        boolean isSum = sumNumRange (firstNum, secondNum);
        if (isSum){
            System.out.println("Сумма чисел " + firstNum + " и " + secondNum + " находится в диапазоне от 10 до 20 включительно");
        } else{
            System.out.println("Сумма чисел " + firstNum + " и " + secondNum + " не входит в диапазон от 10 до 20 включительно");
        }

        //Вызываем метод проверки положительности числа
        int posNum = 0;
        posValueCheck(posNum);

        //Вызываем логический метод проверки положительности числа
        int posNumLogic = 7;
        if (posValueCheckLogical(posNumLogic)){
            System.out.println(posNumLogic + " число отрицательное, так как метод возвращает " + posValueCheckLogical(posNumLogic));
        } else {
            System.out.println(posNumLogic + " число положительное, так как метод возвращает " + posValueCheckLogical(posNumLogic));
        }


        //Вызов метода приветсвия пользователя
        String userName = "Павел";
        userGreetings (userName);

        isLeapYear(2000);

    }

    /*Создаем метод вычисления выражения a * (b + (c / d)) и возвращаем результат
    Так как аргументы метода заранее известны, то проверку деления на ноль делать не нужно*/
    static float calcExp(float a, float b, float c, float d)
    {
        float result = (c / d + b) * a;
        return result;
    }

    /*Создаем метод проверки суммы чисел на соответствие заранее известному диапазону
    и возвращаем логически тип результата проверки*/
    static boolean sumNumRange(int a, int b)
    {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    //Создаем метод определения положительного или отрицательного значения числа
    static void posValueCheck (int a){
        if (a >= 0){
            System.out.println("Число "+ a + " положительное");;
        } else {
            System.out.println("Число "+ a + " отрицательное");
        }
    }

    //Создаем логический метод определения положительного или отрицательного значения числа
    static boolean posValueCheckLogical (int a){
        if (a >= 0){
            return false;
        } else {
            return true;
        }
    }

    //Создаем метод приветствия пользователя
    static void userGreetings (String str2){
        System.out.println("Привет, " + str2 + "!");
    }

    static void isLeapYear (int givenYear){
        if (givenYear % 4 == 0 && givenYear % 100 != 0 || givenYear % 400 == 0){
            System.out.println(givenYear + " високосный год");
        } else {
            System.out.println(givenYear + " не високосный год");
        }
    }
}