package com.homel.interviews.epam;

public class FindNumberClosestTo100 {
    public static void main(String[] args) {
        find(100, 1); //100
        find(-2, -5); // -2
        find(153, 99); // 99
    }

    private static void find(int i, int j) {
        int constant = 100;

        int left = Math.abs(i - constant);
        int right = Math.abs(j - constant);
        if (left < right) {
            System.out.println(i);
            return;
        }
        System.out.println(j);
    }
}
