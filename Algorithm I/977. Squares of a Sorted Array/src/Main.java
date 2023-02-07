import java.util.Arrays;

class Main {
    public static void main(String[] args) {

    }

}

class Solution {
    public static int[] sortedSquares(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}



