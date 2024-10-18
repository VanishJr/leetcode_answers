import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Max-heap to store the letters with their counts
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> y.count - x.count);

        if (a > 0) maxHeap.offer(new Pair('a', a));
        if (b > 0) maxHeap.offer(new Pair('b', b));
        if (c > 0) maxHeap.offer(new Pair('c', c));

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            // Get the character with the most occurrences
            Pair first = maxHeap.poll();

            // Check if we can add this character to the result
            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == first.letter && result.charAt(len - 2) == first.letter) {
                // If adding this character will result in three consecutive letters,
                // we need to pick the next character (if available)
                if (maxHeap.isEmpty()) {
                    // No other characters to pick from, return what we've built so far
                    break;
                }

                // Get the second most frequent character
                Pair second = maxHeap.poll();
                result.append(second.letter);
                second.count--;

                // If the second character still has occurrences, put it back in the heap
                if (second.count > 0) {
                    maxHeap.offer(second);
                }

                // Put the first character back into the heap for future use
                maxHeap.offer(first);
            } else {
                // Otherwise, we can safely add the first character
                result.append(first.letter);
                first.count--;

                // If it still has occurrences, put it back in the heap
                if (first.count > 0) {
                    maxHeap.offer(first);
                }
            }
        }

        return result.toString();
    }

    // Helper class to store character and its count
    private class Pair {
        char letter;
        int count;

        Pair(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }
}
