package com.homel.interviews.luxsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicate {

    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(nums[i])) {
                temp.add(nums[i]);
            } else {
                result.add(nums[i]);
            }
        }

        return new ArrayList<>(result);
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        Set<Integer> result = new HashSet<>();


        for (int val : nums) {
            if (temp.contains(val)) {
                result.add(val);
            } else {
                temp.add(val);
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        List<Integer> duplicates2 = findDuplicates2(new int[]{1, 1, 2, 3, 4, 4, 5});
    }
}
