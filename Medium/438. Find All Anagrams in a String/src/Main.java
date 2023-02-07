import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;
        int[] charCount = new int[26];
        for (char c : p.toCharArray()) charCount[c - 'a']++;
        int start = 0, end = 0, count = p.length();
        while (end < s.length()) {
            if (charCount[s.charAt(end++) - 'a']-- >= 1) count--;
            if (count == 0) result.add(start);
            if (end - start == p.length() && charCount[s.charAt(start++) - 'a']++ >= 0) count++;
        }
        return result;
    }
}
