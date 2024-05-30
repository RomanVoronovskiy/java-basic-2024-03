package ru.otus.java.basic.lesson17;


import ru.otus.java.basic.lesson17.util.Measure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class LinkedListVsArrayList {
    static int SIZE = 100_000;

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        Measure.stamp();
        insert(arrayList);
        Measure.print();

        Measure.stamp();
        insert(linkedList);
        Measure.print();

//        Measure.stamp();
//        search(arrayList);
//        Measure.print();
//
//        Measure.stamp();
//        search(linkedList);
//        Measure.print();
    }

    private static void search(List<Integer> list) {
        for (int i = 0; i < SIZE; i ++) {
            list.get(i);
        }
    }

    static void insert(List<Integer> list) {
        for (int i = 0; i < SIZE; i ++) {
//                list.add(i);
//            list.add(list.size()/2,i);
            list.add(0,i);
        }
    }
}
