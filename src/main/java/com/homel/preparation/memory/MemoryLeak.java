package com.homel.preparation.memory;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeak {
    public static void main(String[] args) {
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
}
