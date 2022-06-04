package com.homel.interviews.luxsoft;

public class SwapWithoutTemp {

    public static void main(String[] args) {
        int[] ints = new int[] {2, 4};

        swap(ints, 0, 1);
    }

    private static void swap(int[] ints, int i, int j) {
        ints[i] = ints[i] + ints[j];
        ints[j] = ints[i] - ints[j];
        ints[i] = ints[i] - ints[j];
    }
}
