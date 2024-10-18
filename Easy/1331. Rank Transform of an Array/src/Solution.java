import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) {
            return new int[0];
        }

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for(int i = 0; i < arr.length; i++) {
            if(!rankMap.containsKey(sortedArr[i])) {
                rankMap.put(sortedArr[i], rank++);
            }
        }

        int[] result = new int[arr.length];
        for(int j = 0; j < arr.length; j++) {
            result[j] = rankMap.get(arr[j]);
        }

        return result;

    }
}