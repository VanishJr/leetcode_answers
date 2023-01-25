public class Main {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution.moveZeroes(nums);
    }
}

// nums = [0,1,0,3,12]
// nums = [0,0,1,3,12]

class Solution {
    public static void moveZeroes(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp++;
            } else if (temp > 0) {
                int t = nums[i];
                nums[i] = 0;
                nums[i - temp] = t;
            }
        }
    }
}