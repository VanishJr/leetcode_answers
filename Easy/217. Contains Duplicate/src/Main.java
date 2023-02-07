import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        int[] nums = {3, 3};

        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(nums));

    }

}

class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);

        }
        return false;
    }

}

