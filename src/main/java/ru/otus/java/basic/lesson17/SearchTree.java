package ru.otus.java.basic.lesson17;

import java.util.List;

public interface SearchTree {

    /**
     * @param element to find
     * @return element if exists, otherwise - null
     */
    String find(String element);

    List<String> getSortedList();
}
