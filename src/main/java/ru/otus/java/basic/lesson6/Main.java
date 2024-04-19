package ru.otus.java.basic.lesson6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        useInventory();
    }

    /**
     * @apiNote Консольное приложение "Рюкзак"
     * <br> (все эти вызовы мы делали в методе main,но также можно вынести в метод, как представлено ниже)
     */
    private static void useInventory() {
        Inventory inventory = new Inventory();
        inventory.add("sandwich");
        inventory.add("compass");
        inventory.add("rake");
        inventory.add("tent");
        inventory.add("water");
        inventory.add("shovel");
        inventory.print();
        int k = inventory.count();
        System.out.println("k = " + k);
        inventory.dropByName("tent");
        inventory.print();
        inventory.add("shovel");
        inventory.print();
        inventory.dropByName("snow");
        inventory.clear();
        inventory.print();
    }

    /**
     * @apiNote Консольная игра "Поле чудес"
     */
    private static void fieldOfMiracles() {
        String[] fruits = {
                "apple", "plum", "kiwi", "pear", "pineapple", "grape", "strawberry", "cherry",
                "banana", "lemon", "melon", "blueberry"
        };
        Scanner scanner = new Scanner(System.in);
        int randomIndex = (int) (Math.random() * fruits.length);
        String wordToGuess = fruits[randomIndex];

        char[] cache = new char[wordToGuess.length()];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = '*';
        }

        boolean win = false;
        while (!win) {
            System.out.println("Критим барабан. Назовите букву:");
            char letter = scanner.next().charAt(0);
            char[] toGuess = wordToGuess.toCharArray();
            for (int i = 0; i < toGuess.length; i++) {
                if (toGuess[i] == letter) {
                    cache[i] = letter;
                }
            }
            boolean flag = true;
            for (int i = 0; i < cache.length; i++) {
                System.out.print(cache[i]);
                if (cache[i] == '*') {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Вы победили!");
                win = true;
            }
            System.out.println();
        }
        System.out.println("Игра окончена!");
    }

    /**
     * @apiNote Консольная игра "Угадай слово"
     */
    private static void questionWord() {
        String[] fruits = {
                "apple", "plum", "kiwi", "pear", "pineapple", "grape", "strawberry", "cherry",
                "banana", "lemon", "melon", "blueberry"
        };
        Scanner scanner = new Scanner(System.in);
        int randomIndex = (int) (Math.random() * fruits.length);
        String wordToGuess = fruits[randomIndex];
        System.out.println("Игра началась. Компьютер загадал слово");
        boolean win = false;

        while (!win) {
            System.out.println("Введи ответ:");
            String inputFruit = scanner.next();
            char[] toGuess = wordToGuess.toCharArray();
            char[] input = inputFruit.toCharArray();
            if (wordToGuess.equals(inputFruit)) {
                System.out.println("вы Угадали!");
                win = true;
            } else {
                for (int i = 0; i < toGuess.length && i < input.length; i++) {
                    if (toGuess[i] == input[i]) {
                        System.out.print(input[i]);
                    } else {
                        System.out.print("*");
                    }
                }
                for (int i = Math.min(toGuess.length, input.length); i < 12; i++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println("Игра завершена");
    }

    /**
     * @apiNote поиск максимального/минимального числа в одномерном массиве
     */
    private static void minMax() {
        int[] array = {-1, -2, -5, -9, 3, -4, -7, 9, -8};
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
