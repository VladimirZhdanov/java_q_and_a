package com.homel.interviews.diablocom;

import java.util.LinkedList;

public class Ways {

    static int myWays(int n, int k) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            ll.add(1);
        }
        int count = 1;
        int temp = 1;

        while (!ll.isEmpty() && ll.getFirst() < k) {
            for (int i = 0; i < ll.size(); i++) {
                ll.set(i, ll.get(i) + temp);
                ll.removeLast();
                count++;
            }
        }
        return count;
    }

     static int numberOfWaysForSum(int n, int k) {
        int[][] a = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            a[1][i] = 1;

        }
        for (int i = 1; i <= k; i++) {
            a[i][0] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= i) {
                    a[i][j] = a[i][j - i] + a[i - 1][j];

                } else {
                    a[i][j] = a[i - 1][j];
                }

            }
        }
        return a[k][n];
    }

    static int numberOfways(int N, int K) {

        // Initialize a list
        int[] dp = new int[N + 1];

        // Update dp[0] to 1
        dp[0] = 1;

        // Iterate over the range [1, K + 1]
        for (int row = 1; row < K + 1; row++) {

            // Iterate over the range [1, N + 1]
            for (int col = 1; col < N + 1; col++) {

                // If col is greater
                // than or equal to row
                if (col >= row)

                    // Update current
                    // dp[col] state
                    dp[col] = dp[col] + dp[col - row];
            }
        }

        // Return the total number of ways
        return(dp[N]);
    }

    public static void main(String[] args) {
        System.out.println(numberOfways(5, 3));

        System.out.println(myWays(5, 3));

        System.out.println(numberOfWaysForSum(5, 3));
//
//        System.out.println(numberOfways(842, 91));
//
//        System.out.println(myWays(842, 91));
    }
}
