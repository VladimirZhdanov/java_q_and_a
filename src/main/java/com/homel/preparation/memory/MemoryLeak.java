package com.homel.preparation.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryLeak {

    private static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        //case1();
        case2();
    }

    private static void case1() {
        HeapAndStack heapAndStack = new HeapAndStack();
        String s = "S";
        int j = 0;

        Map<int[], String> badMap = new HashMap<>();
        Map<String, String> goodMap = new HashMap<>();
        int i = 0;
        while (true) {
            while (i < 1_000_00) {
                badMap.put(new int[]{1,2}, i + "");
                goodMap.put(i + "", i + "");
                i++;
                System.out.println(i);
            }
        }
    }

    private static void case2() {
        int i = 0;
        while (true) {
            while (i < 5_000_00) {
                list.add(i);
                i++;
            }
        }
    }
}
