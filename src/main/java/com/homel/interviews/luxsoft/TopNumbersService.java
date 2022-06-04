package com.homel.interviews.luxsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/* Given infinite stream of integers.
Using only JDK library implement class which would process those integers and at any moment will be able to provide N unique biggest values among all processed.
Class interface:
1. N is class constructor argument, immutable.
2. void push(int val) - process integers one-by-one.
3. int[] top() or Collection<Integer> top().
*/
class TopNumbersService {
    private final int SIZE;
    private final TreeSet<Integer> list;
    private final Object l = new Object();

    TopNumbersService(int size) {
        SIZE = size;
        this.list = new TreeSet<>();
    }

    public void push(int val) {
        synchronized (l) {
            if (list.size() < SIZE) {
                list.add(val);
            } else if (!list.contains(val)) {
                if (val > list.first()) {
                    list.remove(list.first());
                    list.add(val);
                }
            }
            if (list.size() == SIZE) {
                l.notify();
            }
        }
    }

    public List<Integer> top() throws InterruptedException {
        synchronized (l) {
            l.wait();
            return new ArrayList<>(list);
        }
    }

    public static void main(String[] args) {
        TopNumbersService topNumbersService = new TopNumbersService(2);

        Thread t1 = new Thread(() -> {
            topNumbersService.push(1);
            topNumbersService.push(2);
            topNumbersService.push(3);
        });
        Thread t2 = new Thread(() -> {
            try {
                List<Integer> top = topNumbersService.top();
                top.forEach(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}