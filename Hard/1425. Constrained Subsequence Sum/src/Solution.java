import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        // Очередь для хранения индексов с максимальными значениями
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);

        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            // Убираем из очереди те индексы, которые уже вне пределов диапазона k
            if (deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            // Вычисляем dp[i]: либо текущий элемент, либо добавляем к нему максимум из предыдущих значений
            dp[i] = nums[i] + Math.max(0, dp[deque.peekFirst()]);

            // Обновляем максимальную сумму
            maxSum = Math.max(maxSum, dp[i]);

            // Удаляем из очереди все элементы, которые меньше dp[i], так как они нам больше не нужны
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }

            // Добавляем текущий индекс в очередь
            deque.offerLast(i);
        }

        return maxSum;
    }
}
