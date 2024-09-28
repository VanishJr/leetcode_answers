public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] testCases = {
                "Hello World",
                "   fly me   to   the moon  ",
                "luffy is still joyboy",
                "single",
                "multiple words here",
                "    ",
                "",
                "a ",
                " a",
                "word ",
                " word",
                "Hello World   ",
                "   Hello   World",
                "The quick brown fox jumps over the lazy dog",
                "Hello",
                "   leading spaces",
                "trailing spaces   ",
                "   both   ",
                "word1 word2 word3",
                "1234567890",
                "Special_characters!@#$%^&*()",
                "New\nLine",
                "Tabs\tare\there",
                "Line with punctuation, period.",
                "Mix of UPPER and lower case letters"
        };

        for (String testCase : testCases) {
            int result = solution.lengthOfLastWord(testCase);
            System.out.println("Input: \"" + testCase + "\"");
            System.out.println("Output: " + result);
            System.out.println("---------------------------");
        }
    }
}


class Solution {
    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        s = s.trim();

        String[] words = s.split("\\s+");
        return words[words.length - 1].length();
    }
}

