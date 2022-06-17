package com.homel.preparation.colection.problem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        // ========================= problem
//        for (String elem : list) {
//            if (elem.equals("a")) {
//                list.remove(elem);
//            }
//        }
        // =========================

        // Solution 1
        // list.removeIf(elem -> elem.equals("a"));

        // Solution 2
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).equals("a")) {
//                list.remove(list.get(i));
//            }
//        }

        // Solution 3
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("a")) {
                iterator.remove();
            }
        }

        list.forEach(System.out::println);
    }
}
