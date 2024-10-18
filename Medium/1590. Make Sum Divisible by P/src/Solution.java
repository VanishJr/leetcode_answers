import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // If the sum is already divisible by p, return 0
        long remainder = totalSum % p;
        if (remainder == 0) return 0;

        // Use a hashmap to store the prefix sum mod p and the index
        HashMap<Long, Integer> modMap = new HashMap<>();
        modMap.put(0L, -1);  // Initialize with mod 0 at index -1
        long prefixSum = 0;
        int minLength = n;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            long currentMod = prefixSum % p;

            // We want (currentMod - remainder) % p == 0, so we need to find a mod in the map
            long targetMod = (currentMod - remainder + p) % p;

            if (modMap.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - modMap.get(targetMod));
            }

            modMap.put(currentMod, i);
        }

        // If minLength is still n, it means no valid subarray was found
        return minLength == n ? -1 : minLength;
    }
}