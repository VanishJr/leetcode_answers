class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Количество тестов, которое можно провести
        int tests = minutesToTest / minutesToDie;

        // Ищем минимальное количество свиней
        int pigs = 0;
        while (Math.pow(tests + 1, pigs) < buckets) {
            pigs++;
        }

        return pigs;
    }
}
