class Solution {
    public int minLength(String s) {
        boolean check = true;
        String str = s;
        while (check != false) {
            if (str.contains("AB")) {
                str = str.replace("AB", "");
            } else if (str.contains("CD")) {
                str = str.replace("CD", "");
            } else {
                check = false;
            }
        }
        return str.length();
    }
}