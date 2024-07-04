package ru.otus.java.basic.lesson26;

public class BoxWithNumber<T extends Number> {
    private T[] numbers;

    public BoxWithNumber(T... numbers) {
        this.numbers = numbers;
    }

    public T[] getNumbers() {
        return numbers;
    }

    public void setNumbers(T[] numbers) {
        this.numbers = numbers;
    }

    public double average() {
        double avg = 0.0;
        for (T number : numbers) {
            avg += number.doubleValue();
        }
        return avg / numbers.length;
    }

    public boolean compareBox(BoxWithNumber<?> another) {
        return Math.abs( this.average() - another.average())<0.0001;
    }
}
