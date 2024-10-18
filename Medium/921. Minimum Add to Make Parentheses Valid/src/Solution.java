class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int result = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                balance++; // -1
            } else {
                balance--;
            }

            if(balance == -1) {
                result++;
                balance = 0;
            }
        }

        return balance + result;
    }
}