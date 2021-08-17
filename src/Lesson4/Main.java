package Lesson4;
/************************************************************************************************************
 * Непобедимый ИИ для поля 3х3 готов с учетом всех условий задания                                          *
 * Для реализации задания при игровом поле более 3х3 есть понимание,                                        *
 * что нужен другой принцип, основанный на переборе всех возможных вариантов.                               *
 * Скорее всего это можно сделать через рекурсию, но пока моих вычислительных мощностей не хватает)))       *
 * В первой версии был салбый ИИ основанный на Random (далее нашел где это можно использовать)                *
 * Во второй усовершенствованый ИИ                                                                          *
 * В третьей версии переписал проверку условия победы через циклы (как-то сложно получилось)                *
 * Я понимаю, что код большой и где-то есть не доработки, но уже боюсь его трогать)))                       *
*************************************************************************************************************/


import java.util.Random;
import java.util.Scanner;

public class Main {//Инициализируем глобальные переменные
    public static Scanner scan = new Scanner(System.in);
    public static Random rnd = new Random();
    public static char[][] field;
    public static int size;
    public static final char DOT_EMPTY = '·';
    public static final char DOT_USER = 'X';
    public static final char DOT_AI = 'O';

    public static void main(String[] args) {//Точка входа

        size = 3;
        initField();
        System.out.println("Добро пожаловать в игру Крестики-Нолики");
        printField();

        while (true){

            if (isFieldFull()){
                System.out.println("Ничья!");
                break;
            }
            if (checkWin(DOT_USER)){
               System.out.println("Поздравляю! Вы победили!");
               break;
            }
            if (checkWin(DOT_AI)){
                System.out.println("К сожалению, выиграл компьютер!");
                break;
            }

            System.out.println("Ход игрока");
            userTurn();//Ход игрока
            printField();

            if (isFieldFull()){
                System.out.println("Ничья!");
                break;
            }
            if (checkWin(DOT_USER)){
                System.out.println("Поздравляю! Вы победили!");
                break;
            }
            if (checkWin(DOT_AI)){
                System.out.println("К сожалению, выиграл компьютер!");
                break;
            }

            System.out.println("Ход компьютера");
            aiTurn();//Ход ИИ
            printField();
        }
        System.out.println("Игра окончена!");
    }

    public static void initField() {//Создаем игровое поле
        field = new char[size][size];
        //Заполняем матрицу размером size
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printField(){//Вывод игрового поля
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size ; j++) {
                System.out.print(field [i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isCellValid (int x, int y){//Проверка ячейки на диапазон координат и состояния ячейки
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        if (field[x][y] != DOT_EMPTY) return false;
        return true;
    }

    public static boolean isFieldFull(){//Проверка заполнения поля
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field [i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char isTurn){//Проверка условия победы
        //проверяем диагонали
        boolean diag1, diag2;
        diag1 = true;
        diag2 = true;
        for (int i = 0; i < size; i++) {
            diag1 &= (field[i][i] == isTurn);
            diag2 &= (field[size-i-1][i] == isTurn);
        }

        if (diag1|| diag2) return true;

        //проверяем строки
        boolean lines = false, colums = false;
        for (int x = 0; x < size; x++) {
            lines = true;
            colums = true;
            for (int y = 0; y < size; y++) {
                lines &= (field[x][y] == isTurn);
                colums &= (field[y][x] == isTurn);
            }
            if (lines || colums) return true;
        }

        /*if(field[0][0] == isTurn && field[0][1] == isTurn && field[0][2] == isTurn) return true; //первая линия
        if(field[1][0] == isTurn && field[1][1] == isTurn && field[1][2] == isTurn) return true; //вторая линия
        if(field[2][0] == isTurn && field[2][1] == isTurn && field[2][2] == isTurn) return true; //третья линия
        if(field[0][0] == isTurn && field[1][0] == isTurn && field[2][0] == isTurn) return true; //первый столбец
        if(field[0][1] == isTurn && field[1][1] == isTurn && field[2][1] == isTurn) return true; //второй столбец
        if(field[0][2] == isTurn && field[1][2] == isTurn && field[2][2] == isTurn) return true; //третий столбец

        if(field[0][0] == isTurn && field[1][1] == isTurn && field[2][2] == isTurn) return true; //1ая диагональ
        if(field[2][0] == isTurn && field[1][1] == isTurn && field[0][2] == isTurn) return true; //2ая диагональ*/
        return false;

    }

    public static void userTurn() {//Ход игрока
        int x, y;
        do {
            x = userInput("строки") - 1;
            y = userInput("столбца") - 1;
        } while (!isCellValid(x, y));
            field [x][y] = DOT_USER;
    }

    public static int userInput (String str){
        int num;
        do {
            System.out.printf("Введите номер %s: ", str);
            num = scan.nextInt();
        } while (num < 0 || num > size);
        return num;
    }

    public static void aiTurn (){//Алгоритм хода ИИ
        int x = -1, y = -1;
        boolean aiWin = false;
        boolean userWin = false;

        for (int i = 0; i < size; i++) {//Ищем выигрышный ход
            for (int j = 0; j < size; j++) {
                if (isCellValid(i, j)){
                    field[i][j] = DOT_AI;
                    if (checkWin(DOT_AI)){
                        x = i;
                        y = j;
                        aiWin = true;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }

        if (!aiWin){//Ищем возможный выигрышный ход пользователя и блокируем его
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (isCellValid(i, j)){
                        field[i][j] = DOT_USER;
                        if (checkWin(DOT_USER)){
                            x = i;
                            y = j;
                            userWin = true;
                        }
                        field[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        if (!aiWin && !userWin){//Ищем куда сходить
            if (isCellValid(1, 1)) {//пытаемся занять центр
                x = 1;
                y = 1;
            } else if (isCellValid(0,0)) {//либо сильную позицию
                x = 0;
                y = 0;
            } else {//когда совсем в тупике)))
                do {
                    x = rnd.nextInt(size);
                    y = rnd.nextInt(size);
                } while (!isCellValid(x, y));
            }
        }
        field[x][y] = DOT_AI;
    }
}

