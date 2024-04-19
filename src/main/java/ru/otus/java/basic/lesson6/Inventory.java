package ru.otus.java.basic.lesson6;

public class Inventory {

    private String[] items = new String[5];

    /**
     * @param item предмет
     * @apiNote метод предназначен для добавление предмета в рюкзак
     * на первое найденное null - значение
     */
    public void add(String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                System.out.println("В рюкзак положили предмет: " + item);
                return;
            }
        }
        System.out.println("В рюкзаке нет места под предмет: " + item);
    }

    /**
     * @apiNote метод предназначен для печати фактического содержимого рюкзака на экран <br>
     * (null значения не печатаются)
     */
    public void print() {
        System.out.print("[");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * @return кол-во вещей
     * @apiNote метод предназначен для подсчета фактического количества вещей находящихся в рюкзаке
     */
    public int count() {
        int result = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                result++;
            }
        }
        return result;
    }

    /**
     * @param item вещь которую хотим удалить
     * @apiNote метод предназначен для удаления 1-й вещи из рюкзака по её названию
     */
    public void dropByName(String item) {
        for (int i = 0; i < items.length; i++) {
            if (item.equals(items[i])) {
                items[i] = null;
                System.out.println("Из рюкзака выброшен предмет: " + item);
                return;
            }
        }
        System.out.println("В рюкзаке нет предмета: " + item +
                " -> его нельзя выбросить");
    }

    /**
     * @apiNote метод предназначен для полного освобождения рюкзака (все вещи выбрасываются)
     */
    public void clear() {
        for (int i = 0; i < items.length; i++) {
            items[i] = null;
        }
        System.out.println("Рюкзак полность пустой!");
    }
}
