package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Find pair with given sum in the array
public class FindPairSum {

    // Approach 1 : Brute force: Time complexity O(n^2)
    /*public static void main(String[] args) {
        int[] num = {8, 7, 2, 5, 3, 1};
        int target = 10;
        System.out.print("input array..");
        for (int n : num) {
            System.out.print(n + " ");
        }
        System.out.println();
        //Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i< num.length - 1; i++) {
            for (int j = i+1; j<num.length;j++) {
                if (num[i]+num[j]==target) {
                    System.out.println("pair found: " + num[i] + ", " + num[j]);
                }
            }
        }
    }*/

    // Approach - 2 : sorting the list: Time complexity O(nlogn)
    /*public static void main(String[] args) {
        final int[] num = {8, 7, 2, 5, 3, 1};
        final int target = 10;

        Arrays.sort(num); // 1 2 3 5 7 8
        int low = 0;
        int high = num.length - 1;
        int sum;

        while (low < high) {
            sum = num[low] + num[high];
            if (sum == target) {
                System.out.println("pair found: " + num[low] + ", " + num[high]);
                return;
            } else if (sum < target) {
                low++;
            } else if (sum > target) {
                high--;
            }
        }

    }*/

    // Approach -3 : Hashing : Time complexity (O(n))
    /*public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        int[] num = { 8, 7, 2, 5, 3, 1 };
        int target = 10;
        for (int i = 0; i < num.length; i++) {
            int val = target - num[i];
            if (set.contains(val)) {
                System.out.println("pair found: " + num[i] + ", " + val);
            } else {
                set.add(num[i]);
            }
        }
    }*/

    // Approach -4 : Hashing : Time complexity (O(n)): Using hashmap
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] num = { 8, 7, 2, 5, 3, 1 };
        int target = 10;
        for (int i = 0; i < num.length; i++) {
            int val = target - num[i];
            if (map.containsKey(val)) {
                System.out.println("pair found: " + num[i] + ", " + val);
                System.out.println("pair found at indices: " + map.get(val) + ", " + i);
            } else {
                map.put(num[i], i);
            }
        }
    }
 }
