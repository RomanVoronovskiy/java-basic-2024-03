package ru.otus.java.basic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        simpleConsoleCalculator();
    }

    /**
     * @apiNote Консольный калькулятор
     */
    public static void simpleConsoleCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        float a = scanner.nextFloat();
        System.out.println("Введите второе число");
        float b = scanner.nextFloat();
        System.out.println("Введите операцию +, -, *, /");
        char operation = scanner.next().charAt(0);
        float result;
        if (operation == '+') {
            result = a + b;
        } else if (operation == '-') {
            result = a - b;
        } else if (operation == '*') {
            result = a * b;
        } else if (operation == '/') {
            result = a / b;
        } else {
            System.out.println("Введена неизвестная операция");
            return;
        }
        System.out.println(a + " " + operation + " " + b + " = " + result);
    }

    /**
     * @apiNote Консольная игра "Угадай число" - расширенная версия
     */
    private static void hardNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Игра угадай число ***");
        while (true) {
            int checkHard;
            do {
                System.out.println("Выберите сложность: \n1 - легко \n2 - средне" +
                        " \n3 - сложно");
                checkHard = scanner.nextInt();
            } while (checkHard < 1 || checkHard > 3);
            int maxTry;
            int maxNumber;
            if (checkHard == 1) {
                maxTry = 3;
                maxNumber = 6;
            } else if (checkHard == 2) {
                maxTry = 2;
                maxNumber = 9;
            } else {
                maxTry = 2;
                maxNumber = 15;
            }
            int question = (int) (Math.random() * maxNumber) + 1;
            System.out.println("Игра началась. Компьютер загадал число от 1 до " + maxNumber + ". У вас " + maxTry + " попыток");
            while (true) {
                int answer;
                do {
                    System.out.println("Введите числа от 1 до " + maxNumber);
                    answer = scanner.nextInt();
                } while (answer < 1 || answer > maxNumber);
                if (question == answer) {
                    System.out.println("Вы победили!");
                    break;
                } else if (question > answer) {
                    System.out.println("Загаданное число больше");
                } else {
                    System.out.println("Загаданное число меньше");
                }
                maxTry--;
                System.out.println("осталось попыток: " + maxTry);
                if (maxTry == 0) {
                    System.out.println("Вы проиграли! Загаданное число: " + question);
                    break;
                }
            }
            System.out.println("Введите Y для повтора");
            String retryAnswer = scanner.next();
            if (!retryAnswer.equals("Y")) {
                System.out.println("Игра окончена!");
                break;
            }
        }
    }

    /**
     * @apiNote Консольная игра "Угадай число" - простая версия
     */
    public static void simpleNumber() {
        Scanner scanner = new Scanner(System.in);
        int question = (int) (Math.random() * 9) + 1;
        int answer;
        do {
            System.out.println("Введите число от 1 до 9");
            answer = scanner.nextInt();
        } while (answer < 1 || answer > 9);
        if (answer == question) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Вы проиграли!");
        }
    }

    /**
     * @apiNote вариант с бесконечным циклом и выходом по условию
     */
    private static void inputRetry() {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true) {
            System.out.println("Введите числа от 1 до 5:");
            n = scanner.nextInt();
            if (n >= 1 && n <= 5) {
                break;
            }
        }
        System.out.println("n=" + n);
    }
}