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
    private final TreeSet<Integer> treeSet;
    private final Object lock = new Object();

    TopNumbersService(int size) {
        SIZE = size;
        this.treeSet = new TreeSet<>();
    }

    public void push(int val) {
        synchronized (lock) {
            if (treeSet.size() < SIZE) {
                treeSet.add(val);
            } else if (!treeSet.contains(val)) {
                if (val > treeSet.first()) {
                    treeSet.remove(treeSet.first());
                    treeSet.add(val);
                }
            }
            if (treeSet.size() == SIZE) {
                System.out.println("notify");
                lock.notify();
            }
        }
    }

    public List<Integer> top() throws InterruptedException {
            synchronized (lock) {
            System.out.println("wait");
            lock.wait();
            return new ArrayList<>(treeSet);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TopNumbersService topNumbersService = new TopNumbersService(3);

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

        t2.start();
        Thread.sleep(100);
        t1.start();
    }
}