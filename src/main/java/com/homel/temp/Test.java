package com.homel.temp;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        int[] nums = new int[] {2, 2, 1, 3, 3};

        int ans=0; //since XOR with 0 returns same number
        for(int i=0; i<nums.length; i++){
            ans ^= nums[i];  // ans = (ans) XOR (array element at i)
        }
        System.out.println(ans);

    }
}
