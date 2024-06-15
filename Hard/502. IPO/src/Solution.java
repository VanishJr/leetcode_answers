class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min-heap for projects based on capital required
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Max-heap for profits
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Fill the minHeap with all projects
        for (int i = 0; i < profits.length; i++) {
            minHeap.add(new int[]{capital[i], profits[i]});
        }

        // Available capital
        int currentCapital = w;

        // Iterate up to k times
        for (int i = 0; i < k; i++) {
            // Move feasible projects from minHeap to maxHeap
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= currentCapital) {
                maxHeap.add(minHeap.poll()[1]);
            }

            // If no projects are affordable, break
            if (maxHeap.isEmpty()) {
                break;
            }

            // Do the most profitable project available
            currentCapital += maxHeap.poll();
        }

        return currentCapital;
    }
}
