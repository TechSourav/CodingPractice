package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find maximum length subarray having a given sum
public class MaxLengthSubArray {

    /*public static void main(String[] args) {
        int arr[] = { -5, 8, -14, 2, 4, 12};
        int target = -5;
        int prev_sum;
        final List<List<Integer>> list1 = new ArrayList<>();
        final List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i <= arr.length-1; i++) {
            prev_sum = arr[i];
            if (prev_sum== target) {
                list1.add(List.of(prev_sum));
            }
            for (int j = i+1; j < arr.length; j++) {
                int sum = prev_sum + arr[j];
                if (sum== target) {
                    final List<Integer> lst3 = new ArrayList<>(traverseArrayAndAddToList(list2, arr, i, j));
                    list1.add(lst3);
                    prev_sum = sum;
                    list2.clear();
                } else {
                    prev_sum = sum;
                }
            }
        }
        int maxLength = 0;
        for (List<Integer> l: list1) {
            System.out.println(l);
            if (l.size() > maxLength) {
                maxLength = l.size();
            }
        }
        System.out.println("Max Length of the subarray is : " + maxLength);
    }

    private static List<Integer> traverseArrayAndAddToList(final List<Integer> lst, int [] arr, int i , int j) {
        for (int k = i; k<=j; k++) {
            lst.add(arr[k]);
        }
        return lst;
    }*/

    // Approach 2: Note: (not working with negative sum)
    /*public static void main(String[] args) {
        int arr[] = { -5, 8, -14, 2, 4, 12 };
        int n = arr.length;
        int k = -5;
        System.out.println(method1(arr, n , k));
    }

    private static int method1(int A[], int N, int K) {
        int i = 0, j = 0, sum = 0;
        int maxLen = Integer.MIN_VALUE;

        while (j < N) {
            sum = sum + A[j];
            if (sum < K) {
                j++;
            } else if (sum == K) {
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            } else if (sum > K) {
                while (sum > K && i < N) {
                    sum = sum - A[i];
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }*/

    // Find the maximum length subarray with sum `S` present in a given array
    public static void findMaxLenSubarray(int[] nums, int S)
    {
        // create an empty HashMap to store the ending index of the first
        // subarray having some sum
        Map<Integer, Integer> map = new HashMap<>();

        // insert (0, -1) pair into the set to handle the case when a
        // subarray with sum `S` starts from index 0
        map.put(0, -1);

        int target = 0;

        // `len` stores the maximum length of subarray with sum `S`
        int len = 0;

        // stores ending index of the maximum length subarray having sum `S`
        int ending_index = -1;

        // traverse the given array
        for (int i = 0; i < nums.length; i++)
        {
            // sum of elements so far
            target += nums[i];

            // if the sum is seen for the first time, insert the sum with its
            // into the map
            map.putIfAbsent(target, i);

            // update length and ending index of the maximum length subarray
            // having sum `S`
            if (map.containsKey(target - S) && len < i - map.get(target - S))
            {
                len = i - map.get(target - S);
                ending_index = i;
            }
        }

        // print the subarray
        System.out.println("Max length: " + len);
        System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
    }

    public static void main (String[] args)
    {
        int[] nums = { -5, 8, -14, 2, 4, 12 };
        int target = -5;

        findMaxLenSubarray(nums, target);
    }
}
