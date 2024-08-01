package com.homel.interviews.greenatom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

// todo: implement
public class IteratorWithFilter<E> implements Iterator<E> {

    private final Iterator<E> iterator;
    private final Predicate<E> filter;
    private E nextElement;

    public IteratorWithFilter(Iterator<E> iterator, Predicate<E> filter) {
        this.iterator = iterator;
        this.filter = filter;
        this.nextElement = findNextElement();
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }

    @Override
    public E next() {
        if (nextElement == null) {
            throw new NoSuchElementException();
        }
        E result = nextElement;
        nextElement = findNextElement();
        while (nextElement == null && iterator.hasNext()) nextElement = findNextElement();
        return result;
    }

    private E findNextElement() {
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (element == null) return null;
            if (filter.test(element)) {
                return element;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(null);
        list.add(null);
        list.add(5);
        list.add(6);
        list.add(7);

        var iterator = list.iterator();

        var wrapper = new IteratorWithFilter<>(iterator, e -> e % 2 == 0);

        while (wrapper.hasNext()) {
            System.out.println(wrapper.next());
        }
  /* ожидаемый вывод
  2
  4
  6
  */
    }

    private static class Null {

    }
}
