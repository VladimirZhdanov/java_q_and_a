package com.homel.interviews.vk.first;

import java.util.Arrays;

// Дан список интов, повторяющихся элементов в списке нет.
// Нужно преобразовать это множество в строку, сворачивая соседние по числовому ряду числа в диапазоны.
//
// Примеры:
// [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
// [1,4,3,2] => "1-4"
// [1,4] => "1,4"
public class CompressService {

    public static void main(String[] args) {
        System.out.println(compress(new int[]{1,4,5,2,3,9,8,11,0}));
        System.out.println(compress(new int[]{1,4,3,2}));
        System.out.println(compress(new int[]{1,4}));
    }

    public static String compress(int[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        int start = array[0];
        int prev = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == prev + 1) {
                prev = array[i];
            } else {
                if (start == prev) {
                    sb.append(start);
                } else {
                    sb.append(start).append("-").append(prev);
                }
                sb.append(",");
                start = array[i];
                prev = array[i];
            }
        }
        if (start == prev) {
            sb.append(start);
        } else {
            sb.append(start).append("-").append(prev);
        }
        return sb.toString();
    }
}
