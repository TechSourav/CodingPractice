package array;

import java.util.Arrays;

/**
 * Given a binary array, sort it in linear time and constant space. The output should print all zeroes, followed by all ones.
 * */
public class SortBinaryArray {

    public static void main(String[] args) {

        final int[] A = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };

        sort(A);

        // print the rearranged array
        System.out.println(Arrays.toString(A));

    }

    private static void sort(final int[] A) {
        int k = 0;
        for (int i : A) {
            if (i == 0) {
                A[k++] = 0;
            }
        }
        for (int j = k; j<A.length; j++) {
            A[k++] = 1;
        }
    }

}
