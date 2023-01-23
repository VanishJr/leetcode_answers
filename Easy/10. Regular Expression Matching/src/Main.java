public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            boolean ignore = isMatch(s, p.substring(2));
            boolean match = firstMatch && isMatch(s.substring(1), p);
            return ignore || match;
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

}