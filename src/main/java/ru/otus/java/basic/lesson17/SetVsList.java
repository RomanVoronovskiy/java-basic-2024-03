package ru.otus.java.basic.lesson17;


import ru.otus.java.basic.lesson17.SetVsList.Machine;
import ru.otus.java.basic.lesson17.util.Measure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class SetVsList {
    static int SIZE = 100000;

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        Measure.stamp();
        insert(arrayList);
        Measure.print();

        Measure.stamp();
        insert(hashSet);
        Measure.print();

        Measure.stamp();
        search(arrayList);
        Measure.print();

        Measure.stamp();
        search(hashSet);
        Measure.print();

//        Machine machineOne = new Machine("UAZ");
//        Machine machineTwo = new Machine("GAZ");
//        Machine machineThree = new Machine("BMW");
//        HashSet<Machine> hashSetTwo = new HashSet<>(Arrays.asList(
//                machineOne, machineTwo
//        ));
//
//        if(hashSetTwo.contains(machineThree)){
//            System.out.println("OK!");
//        }else{
//            System.out.println(" NOT OK!");
//        }
    }

    static void insert(Collection<Integer> list) {
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    static void search(Collection<Integer> list) {
        for (int i = 0; i < SIZE; i++) {
            list.contains(i);
        }
    }

    static class Machine {
        String type;

        public Machine(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
