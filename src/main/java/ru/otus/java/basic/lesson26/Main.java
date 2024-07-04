package ru.otus.java.basic.lesson26;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SimpleBox intBox1 = new SimpleBox(10);
        SimpleBox intBox2 = new SimpleBox(20);

        int sum = (Integer) intBox1.getObj() + (Integer) intBox2.getObj();
        System.out.println("sum = " + sum);
        // 500 строк кода
        intBox1.setObj("Java");
        // 500 строк кода
        if (intBox1.getObj() instanceof Integer && intBox2.getObj() instanceof Integer) {
            int sum2 = (Integer) intBox1.getObj() + (Integer) intBox2.getObj();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("error");
        }

//        GenBox<int> intGenBox0 = new GenBox<>(11); ограничение на создание класса с примитивным типом в качестве T
        GenBox<Integer> intGenBox1 = new GenBox<>(11);
        GenBox<Integer> intGenBox2 = new GenBox<>(22);
        int sum3 = intGenBox1.getObj() + intGenBox2.getObj();

//        intGenBox1.setObj("java2"); ошибка компиляции а не выполнения как в SimpleBox

        System.out.println("sum3 = " + sum3);

        BoxWithNumber<Integer> boxWithNumber1 = new BoxWithNumber(1, 2, 3, 4);
        BoxWithNumber<Integer> boxWithNumber12 = new BoxWithNumber(1, 2, 3, 4);
        BoxWithNumber<Float> boxWithNumber2 = new BoxWithNumber(1f, 2f, 3f, 4f);
        BoxWithNumber<Double> boxWithNumber3 = new BoxWithNumber(1.0, 2.0, 3.0, 4.0);
        System.out.println("boxWithNumber1.average() = " + boxWithNumber1.average());
        System.out.println("boxWithNumber2.average() = " + boxWithNumber2.average());
        System.out.println("boxWithNumber3.average() = " + boxWithNumber3.average());

        System.out.println("boxWithNumber1.compareBox(boxWithNumber12) = " + boxWithNumber1.compareBox(boxWithNumber12));

        System.out.println("boxWithNumber1.compareBox(boxWithNumber2) = " + boxWithNumber1.compareBox(boxWithNumber2));

//        GenBox<String> genStringBox = new GenBox<>("box1"); стирание
//        genStringBox.setObj("box2");
//
//        BoxWithNumber boxWithNumber4 = new BoxWithNumber<>(1,2,3);
//        boxWithNumber4.setNumbers();
        List<Number> numberList = List.of(1,2,3,4);
        System.out.println(sum(numberList));
        List<Integer> integerList= List.of(1,2,3,4);
        System.out.println(sum(integerList));
//        List<String> stringList= new ArrayList<>(); ошибка по ограничению wildcard
//        System.out.println(sum(stringList));
//        Collections.copy(); тут посмотреть PECS
    }

    public static double sum(List<? extends Number> list){
        double result = 0.0;
        for (Number number : list) {
            result+=number.doubleValue();
        }
        return result;
    }

    public static Object getFirstElement(List<?> list){
        return list.get(0);
    }

    public static <T> T getFirstElementTwo(List<T> list){
        return list.get(0);
    }

}
