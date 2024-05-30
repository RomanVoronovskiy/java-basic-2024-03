package ru.otus.java.basic.lesson17;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        //TODO: FIFO
//        Deque<Integer> deque = new LinkedList<>();
//        deque.add(1);
//        deque.add(2);
//        deque.add(3);
//
//        while (!deque.isEmpty()){
//            System.out.println(deque.poll());
//        }
        // TODO: LIFO
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);

        while (!deque.isEmpty()){
            System.out.println(deque.poll());
        }
    }
}
