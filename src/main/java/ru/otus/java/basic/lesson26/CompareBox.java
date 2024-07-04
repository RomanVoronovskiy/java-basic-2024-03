package ru.otus.java.basic.lesson26;

public class CompareBox implements Comparable<CompareBox>{
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public CompareBox(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(CompareBox o) {
        return this.size-o.size;
    }
}
