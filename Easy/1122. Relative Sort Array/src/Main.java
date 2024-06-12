import java.util.*;

public class Main {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> frequency = new HashMap<>();
        // Count the frequency of each element in arr1
        for (int num : arr1) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        // First place elements of arr1 that appear in arr2
        for (int num : arr2) {
            int count = frequency.get(num);
            while (count > 0) {
                arr1[index++] = num;
                count--;
            }
            frequency.remove(num); // Remove the element from map once processed
        }

        // Now process the remaining elements that were not in arr2
        // Since these should be sorted in ascending order, first collect them
        List<Integer> remaining = new ArrayList<>(frequency.keySet());
        Collections.sort(remaining);

        // Place remaining elements sorted in ascending order
        for (int num : remaining) {
            int count = frequency.get(num);
            while (count > 0) {
                arr1[index++] = num;
                count--;
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        arr1 = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
    }
}
