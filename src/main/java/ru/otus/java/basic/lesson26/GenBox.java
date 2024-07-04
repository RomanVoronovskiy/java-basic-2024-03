package ru.otus.java.basic.lesson26;

public class GenBox<T> {
    private T obj;

//    public static T myStaticField = 1;  ограничение на создание статичного поля с T типом

    public GenBox(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
//        T instant = new T(); ограничение на создание объекта с T типом
        this.obj = obj;
    }
}
