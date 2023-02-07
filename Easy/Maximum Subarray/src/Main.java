public class Main {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
       int maxSub = nums[0];
       int curSum = 0;

       for (int num : nums) {
           curSum += num;
           maxSub = Math.max(curSum, maxSub);

           if (curSum < 0) {
               curSum = 0;
           }
       }
       return maxSub;
    }
}