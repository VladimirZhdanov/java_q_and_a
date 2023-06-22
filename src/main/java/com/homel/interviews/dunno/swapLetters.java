package com.homel.interviews.dunno;

public class swapLetters {

//    public static void main(String[] args) {
//        String str = "google";
//
//        char[] arr = str.toCharArray();
//        char[] result = new char[arr.length];
//        int j = 0;
//        for (int i = arr.length - 1; i >= 0; i--) {
//            result[j] = arr[i];
//            j++;
//        }
//
//        System.out.println(new String(result));
//    }

    public static void main(String[] args) {
        String str = "google";
        char[] result = new char[str.length()];

        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            char l = str.charAt(left);
            char r = str.charAt(right);
            result[left] = r;
            result[right] = l;

            left++;
            right--;
        }

        System.out.println(String.copyValueOf(result));
    }
}
