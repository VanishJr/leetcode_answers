public class Main {
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow before multiplying and adding
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            reversed = reversed * 10 + digit;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Main sol = new Main();
        System.out.println(sol.reverse(123));  // Output: 321
        System.out.println(sol.reverse(-123)); // Output: -321
        System.out.println(sol.reverse(120));  // Output: 21
    }
}
