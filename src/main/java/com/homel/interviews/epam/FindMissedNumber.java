package com.homel.interviews.epam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissedNumber {
    public static void main(String[] args) {
        // Find 3, cuz it's missed (we do not know what exactly value is)
        int[] nums = new int[] {7, 4, 2, 5, 6, 1, 8, 9};

        solution3(nums);

        solution2(nums);

        solution1(nums);
    }

    private static void solution3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }

        for (int i = 1; i < set.size(); i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void solution2(int[] nums) {
        int counter = 1;

        sort(nums, 0, nums.length - 1);

        for (int val : nums) {
            if (val != counter) {
                System.out.println(counter);
                break;
            } else {
                counter++;
            }
        }
    }

    private static void sort(int[] nums, int low, int high) {
        if (nums.length == 0) return;
        if (low >= high) return;

        int midIndex = low + (high - low) / 2;
        int midValue = nums[midIndex];

        int i = low;
        int j = high;

        while (i <= j) {
            while (nums[i] < midValue) i++;
            while ((nums[j] > midValue)) j--;

            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (low < i) sort(nums, low, j);
        if (high > j) sort(nums, i, high);
    }

    private static void solution1(int[] nums) {
        int constant = (9 * (9 + 1)) / 2;

        int sum = Arrays.stream(nums).sum();
        int result = constant - sum;

        System.out.println(result);
    }
}
