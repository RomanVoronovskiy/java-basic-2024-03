package ru.otus.java.basic.lesson8;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static char[][] gameField = new char[3][3];
    static final char CROSS = 'X';
    static final char ZERO = '0';
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        init();
        printField();
        boolean gameOn = true;
        while (gameOn) {
            getTurnHuman(CROSS);
            printField();
            if (isWon(CROSS)) {
                System.out.println(CROSS + " -> WINNER!!!");
                return;
            }

            if (isGameOver()) {
                System.out.println("Ничья");
                return;
            }

            getTurnRobot(ZERO);
            printField();
            if (isWon(ZERO)) {
                System.out.println(ZERO + " -> WINNER!!!");
                return;
            }

            if (isGameOver()) {
                System.out.println("Ничья");
                return;
            }
        }
    }

    /**
     * @param currentLetter текущий символ
     * @return следующий символ
     * @apiNote ютильный метод для игры 2-х человек, разбирали реализацию на семинаре (смена хода)
     */
    private static char switchLetter(char currentLetter) {
        if (currentLetter == CROSS) {
            currentLetter = ZERO;
        } else {
            currentLetter = CROSS;
        }
        return currentLetter;
    }

    /**
     * @param letter символ для проверки на победу
     * @return победил?
     * @apiNote обобщающий метод, который проверяет на победу стороны для всех 3-х случаев
     */
    private static boolean isWon(char letter) {
        return isHorizontalField(letter) || isVerticalField(letter) ||
                isDiagonalField(letter);
    }


    /**
     * @param letter символ для проверки на победу
     * @return победил?
     * @apiNote метод предназначен для проверки горизонталей (строк) матрицы на победный исход
     */
    private static boolean isHorizontalField(char letter) {
        for (int i = 0; i < gameField.length; i++) {
            if ((gameField[i][0] == letter) &&
                    (gameField[i][1] == letter) &&
                    (gameField[i][2] == letter)) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param letter символ для проверки на победу
     * @return победил?
     * @apiNote метод предназначен для проверки вертикалей (столбцов) матрицы на победный исход
     */
    private static boolean isVerticalField(char letter) {
        for (int i = 0; i < gameField.length; i++) {
            if ((gameField[0][i] == letter) &&
                    (gameField[1][i] == letter) &&
                    (gameField[2][i] == letter)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param letter символ для проверки на победу
     * @return победил?
     * @apiNote метод предназначен для проверки диагоналей матрицы на победный исход
     */
    private static boolean isDiagonalField(char letter) {
        return ((gameField[0][0] == letter) && (gameField[1][1] == letter) && (gameField[2][2] == letter))
                ||
                ((gameField[0][2] == letter) && (gameField[1][1] == letter) && (gameField[2][0] == letter));
    }

    /**
     * @return статус игры
     * @apiNote метод предназначен для проверки на заполненность всего игрового поля (Ничья)
     */
    private static boolean isGameOver() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (gameField[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param letter символ, которым ходит человек (Х или 0)
     * @apiNote метод предназначен для эмитации хода человека(ввод значения координат с кл-ы)
     */
    private static void getTurnHuman(char letter) {
        int y;
        int x;
        do {
            System.out.print("y = ");
            y = sc.nextInt() - 1;
            System.out.print("x = ");
            x = sc.nextInt() - 1;
        } while (!setLetter(x, y, letter));
    }

    /**
     * @param letter символ, которым ходит робот (Х или 0)
     * @apiNote метод предназначен для эмитации хода робота, действует по след.правилам:<br>
     * 1 - проверяет поле на наличие победных ходов<br>
     * 2 - проверяет поле на наличие победных ходов для противника и предотвращает их<br>
     * 3 - ставит значение в рандомное свободное место на поле
     */
    private static void getTurnRobot(char letter) {
        char alientLetter = (letter == ZERO) ? CROSS : ZERO;
        int y;
        int x;
        do {
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (gameField[i][j] == ' ') {
                        gameField[i][j] = letter;
                        if (isWon(letter)) {
                            return;
                        }
                        gameField[i][j] = ' ';
                    }
                }
            }

            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (gameField[i][j] == ' ') {
                        gameField[i][j] = alientLetter;
                        if (isWon(alientLetter)) {
                            gameField[i][j] = letter;
                            return;
                        }
                        gameField[i][j] = ' ';
                    }
                }
            }

            y = random.nextInt(3);
            x = random.nextInt(3);
        } while (!setLetter(x, y, letter));
    }


    /**
     * @param x      координата столбца
     * @param y      координата строки
     * @param letter символ для заполнения
     * @return успешно ли заполнили?
     * @apiNote метод предназначен для заполнения ячейки матрицы с проверкой на наличие символа на данной позиции
     */
    private static boolean setLetter(int x, int y, char letter) {
        if (gameField[y][x] == ' ') {
            gameField[y][x] = letter;
            return true;
        }
        return false;
    }


    /**
     * @apiNote метод предназначен для очистки игрового поля
     */
    private static void init() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                gameField[i][j] = ' ';
            }
        }
    }

    /**
     * @apiNote метод предназначен для печати игрового поля на экран
     */
    private static void printField() {
        System.out.print("   ");
        for (int i = 0; i < gameField.length; i++) {
            System.out.print((i + 1) + "   ");
        }
        System.out.println();
        for (int i = 0; i < gameField.length; i++) {
            System.out.print((i + 1) + "|");
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(" " + gameField[i][j] + " |");
            }
            System.out.println();
        }
    }

}
