package ru.otus.java.basic.lesson17;


import ru.otus.java.basic.lesson17.util.Measure;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Key, String> map = new HashMap<>();
        Measure.stamp();
        for (int i = 0; i < 10000; i ++) {
            map.put(new Key(Integer.toHexString(i)), "");
        }
        Measure.print();

        Measure.stamp();
        for (int i = 0; i < 10000; i ++) {
            map.get(new Key(Integer.toHexString(i)));
        }
        Measure.print();
    }

    static class Key {
        String val;

        public Key(String val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(val, key.val);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }

    }
}
