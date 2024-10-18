import java.util.Arrays;

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // Initialize the dp array with a very small value to represent uncomputed states
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        // Dynamic programming to calculate the maximum dot product
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Option 1: Take the current pair (nums1[i-1] and nums2[j-1])
                int takeBoth = nums1[i - 1] * nums2[j - 1];

                // Option 2: Add the previous best subsequence and take the current pair
                dp[i][j] = Math.max(dp[i][j], takeBoth + Math.max(0, dp[i - 1][j - 1]));

                // Option 3: Skip nums1[i-1] and keep the best from previous elements in nums2
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                // Option 4: Skip nums2[j-1] and keep the best from previous elements in nums1
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }
}
