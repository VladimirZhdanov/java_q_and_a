package com.homel.interviews.diablocom;

public class WaysToSum {

    public static void main(String[] args) {
        int res = numberOfways(842, 91);
        System.out.println(res);
    }

    static int numberOfways(int n, int k) {

        // Initialize a list
        int[] dp = new int[n + 1];

        // Update dp[0] to 1
        dp[0] = 1;

        // Iterate over the range [1, K + 1]
        for(int row = 1; row < k + 1; row++) {

            // Iterate over the range [1, N + 1]
            for(int col = 1; col < n + 1; col++) {

                // If col is greater
                // than or equal to row
                if (col >= row)

                    // Update current
                    // dp[col] state
                    dp[col] = dp[col] + dp[col - row];
            }
        }

        // Return the total number of ways
        return(dp[n]);
    }
}
