package com.homel.interviews.raiffeisen.generics;

public class Car extends Vehicle {

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0}));
    }

    public static int maxDistToClosest(int[] seats) {
        int result = 0;

        int prev = 0;
        int next = 0;

        for (int i = 0; i < seats.length; i++) {
            int count = 0;
            if (seats[i] == 0) {
                count++;
                prev = i - 1;
                next = i + 1;
                while (prev > 0 || next < seats.length) {
                    if (prev > 0 && next < seats.length && seats[prev] == 0 && seats[next] == 0) {
                        count++;
                        prev--;
                        next++;
                    } else if (prev < 0 && seats[next] == 0)  {
                        count++;
                        next++;
                    } else if (next >= seats.length && seats[prev] == 0)  {
                        count++;
                        prev--;
                    } else {
                        break;
                    }
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
