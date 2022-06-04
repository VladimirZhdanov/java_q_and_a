package com.homel.interviews.dunno;

public class swapLetters {

    public static void main(String[] args) {
        String str = "google";

        char[] arr = str.toCharArray();
        char[] result = new char[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[j] = arr[i];
            j++;
        }

        System.out.println(new String(result));
    }
}
