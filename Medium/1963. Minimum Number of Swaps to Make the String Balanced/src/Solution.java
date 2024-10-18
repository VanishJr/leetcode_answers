class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int maxImbalance = 0;

        for (char c : s.toCharArray()) {
            if(c == '[') {
                balance++;
            } else {
                balance--;
            }

            if(balance < 0) {
                maxImbalance = Math.max(maxImbalance, -balance);
            }
        }

        return (maxImbalance + 1)/2;

    }
}