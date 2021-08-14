package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {//инициализируем глобальные переменные
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
            aiTurn();//Ход ИИ
            printField();
            if (checkWin(DOT_AI)){
               System.out.println("К сожалению, выиграл компьютер!");
               break;
            }
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

    public static boolean isFieldFull(){//Проверка заполнения поля
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field [i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char isTurn){//Проверка условия победы
        if(field[0][0] == isTurn && field[0][1] == isTurn && field[0][2] == isTurn) return true;
        if(field[1][0] == isTurn && field[1][1] == isTurn && field[1][2] == isTurn) return true;
        if(field[2][0] == isTurn && field[2][1] == isTurn && field[2][2] == isTurn) return true;
        if(field[0][0] == isTurn && field[1][0] == isTurn && field[2][0] == isTurn) return true;
        if(field[0][1] == isTurn && field[1][1] == isTurn && field[2][1] == isTurn) return true;
        if(field[0][2] == isTurn && field[1][2] == isTurn && field[2][2] == isTurn) return true;
        if(field[0][0] == isTurn && field[1][1] == isTurn && field[2][2] == isTurn) return true;
        if(field[2][0] == isTurn && field[1][1] == isTurn && field[0][2] == isTurn) return true;
        return false;
    }

    public static void userTurn() {//Ход игрока
        int x, y;
        do {
            System.out.print("Ваш ход. Введите номер строки:");
            x = scan.nextInt() - 1;
            System.out.print("Ваш ход. Введите номер столбца:");
            y = scan.nextInt() - 1;
        } while (!isCellValid(x, y));
            field [x][y] = DOT_USER;
    }

    public static boolean isCellValid (int x, int y){//Проверка ячейки на диапазон координат и состояния ячейки
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        if (field[x][y] != DOT_EMPTY) return false;
        return true;
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
            do{
                x = rnd.nextInt(size);
                y = rnd.nextInt(size);
            } while (!isCellValid(x, y));
        }
        field[x][y] = DOT_AI;
    }
}

