public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        int expected1 = 0;
        int result1 = solution.strStr(haystack1, needle1);
        System.out.println("Test Case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test Case 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        int expected2 = -1;
        int result2 = solution.strStr(haystack2, needle2);
        System.out.println("Test Case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test Case 3 (additional test)
        String haystack3 = "hello";
        String needle3 = "ll";
        int expected3 = 2;
        int result3 = solution.strStr(haystack3, needle3);
        System.out.println("Test Case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test Case 4 (needle is empty string)
        String haystack4 = "hello";
        String needle4 = "";
        int expected4 = 0;
        int result4 = solution.strStr(haystack4, needle4);
        System.out.println("Test Case 4: " + (result4 == expected4 ? "Passed" : "Failed"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int index = haystack.indexOf(needle);

        return index;
    }
}
