package array;

import java.util.HashMap;

// Given a binary array containing 0’s and 1’s, find the largest subarray with equal numbers of 0’s and 1’s.
public class LargestSubArrWithEqualNum {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 1, 0, 0};

        int size = arr.length;

        System.out.println(findSubArray(arr, size));

    }

    /*static int findSubArray(int arr[], int n)
    {
        int sum = 0;
        int maxsize = -1, startindex = 0;
        int endindex = 0;

        // Pick a starting point as i

        for (int i = 0; i < n - 1; i++) {
            sum = (arr[i] == 0) ? -1 : 1;

            // Consider all subarrays starting from i

            for (int j = i + 1; j < n; j++) {
                if (arr[j] == 0)
                    sum += -1;
                else
                    sum += 1;

                // If this is a 0 sum subarray, then
                // compare it with maximum size subarray
                // calculated so far

                if (sum == 0 && maxsize < j - i + 1) {
                    maxsize = j - i + 1;
                    startindex = i;
                }
            }
        }
        endindex = startindex + maxsize - 1;
        if (maxsize == -1)
            System.out.println("No such subarray");
        else
            System.out.println(startindex + " to " + endindex);

        return maxsize;
    }*/

    static int findSubArray(int arr[], int n)
    {
        // Creates an empty hashMap hM
        final HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;
        int endIndex = 0;
        for (int j = 0; j < n; j++) {
            sum += (arr[j] == 0) ? -1 : 1;
            if (map.containsKey(sum)) {
                if (maxLen < j - map.get(sum)) {
                    maxLen = j - map.get(sum);
                    endIndex = j;
                }
            } else {
                map.put(sum, j);
            }

        }
        System.out.println("[" + (endIndex - maxLen +1) + " , " + endIndex + "]");
        return maxLen;
    }

}
