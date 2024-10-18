class Solution {
    public long appealSum(String s) {
        int[] lastOccurrence = new int[26];  // Массив для хранения последнего индекса каждого символа
        for (int i = 0; i < 26; i++) {
            lastOccurrence[i] = -1;
        }

        long currTotal = 0;  // Используем long для обработки больших значений
        long totalAppeal = 0;

        // Проходим по каждому символу строки
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';  // Индекс символа в диапазоне 0-25
            currTotal += i - lastOccurrence[idx];
            totalAppeal += currTotal;
            lastOccurrence[idx] = i;  // Обновляем последнее появление символа
        }

        return totalAppeal;  // Возвращаем суммарную привлекательность всех подстрок
    }
}
