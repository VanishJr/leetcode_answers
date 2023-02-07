public class Main {
    public static void main(String[] args) {
        int[] tree = { 1,2,1 };
        Solution solution = new Solution();
        System.out.println(solution.totalFruit(tree));
    }
}

class Solution {
    public int totalFruit(int[] tree) {
        int start = 0, end = 0, max = 0, count_basket = 0;
        int[] count = new int[40001];
        for (end = 0; end < tree.length; end++) {
            count[tree[end]]++;
            if (count[tree[end]] == 1) count_basket++;
            while (count_basket > 2) {
                count[tree[start]]--;
                if (count[tree[start]] == 0) count_basket--;
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
