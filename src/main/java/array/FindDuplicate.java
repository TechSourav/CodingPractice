package array;

import java.util.Arrays;
import java.util.stream.IntStream;

// Find the duplicate element in a limited range array
public class FindDuplicate {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 2 };
        int actual_sum = IntStream.of(arr).sum();
        int expected_sum = arr.length * (arr.length-1) /2;
        System.out.println(actual_sum - expected_sum);
        System.out.println("The duplicate element is " + findDuplicate(arr));
    }

    // Function to find a duplicate element in a limited range array
    public static int findDuplicate(int[] nums)
    {
        int duplicate = -1;

        // do for each array element
        for (int i: nums)
        {
            // get the value of the current element
            int val = (i < 0) ? -i : i;

            // make element at index `val` negative if it is positive
            if (nums[val] >= 0) {
                nums[val] = -nums[val];
            }
            else {
                // if the element is already negative, it is repeated
                duplicate = val;
                break;
            }
        }

        // restore the original array before returning
        for (int i = 0; i < nums.length; i++)
        {
            // make negative elements positive
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }

        // return duplicate element
        return duplicate;
    }

}
