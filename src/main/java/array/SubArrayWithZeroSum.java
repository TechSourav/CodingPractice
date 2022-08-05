package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// check if it contains a subarray having zero-sum
public class SubArrayWithZeroSum {

    /*public static void main(String[] args) {
        int[] arr = {  3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        int prev_sum;
        final List<List<Integer>> list1 = new ArrayList<>();
        final List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i <= arr.length-1; i++) {
            prev_sum = arr[i];
            if (prev_sum==0) {
                list1.add(List.of(prev_sum));
            }
            for (int j = i+1; j < arr.length; j++) {
                int sum = prev_sum + arr[j];
                if (sum==0) {
                    final List<Integer> lst3 = new ArrayList<>(traverseArrayAndAddToList(list2, arr, i, j));
                    list1.add(lst3);
                    prev_sum = sum;
                    list2.clear();
                } else {
                    prev_sum = sum;
                }
            }
        }
        for (List<Integer> l: list1) {
            System.out.println(l);
        }
    }

    private static List<Integer> traverseArrayAndAddToList(final List<Integer> lst, int [] arr, int i , int j) {
        for (int k = i; k<=j; k++) {
            lst.add(arr[k]);
        }
        return lst;
    }*/

    // Utility function to insert <key, value> into the multimap
    private static<K, V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {
        // if the key is seen for the first time, initialize the list
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }

    // Function to print all subarrays with a zero-sum in a given array
    public static void printAllSubarrays(int[] nums)
    {
        // create an empty multimap to store the ending index of all
        // subarrays having the same sum
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // insert (0, -1) pair into the map to handle the case when
        // subarray with zero-sum starts from index 0
        insert(hashMap, 0, -1);

        int sum = 0;

        // traverse the given array
        for (int i = 0; i < nums.length; i++)
        {
            // sum of elements so far
            sum += nums[i];

            // if the sum is seen before, there exists at least one
            // subarray with zero-sum
            if (hashMap.containsKey(sum))
            {
                List<Integer> list = hashMap.get(sum);

                // find all subarrays with the same sum
                for (Integer value: list)
                {
                    System.out.println("Subarray [" + (value + 1) + "…" +
                        i + "]");
                }
            }

            // insert (sum so far, current index) pair into the multimap
            insert(hashMap, sum, i);
        }
    }

    public static void main (String[] args)
    {
        int[] nums = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

        printAllSubarrays(nums);
    }

}
