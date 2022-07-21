package Searching;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;

        System.out.println(search(arr, x));
    }

    private static boolean search(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        int m =0;
        while (l <= r) {
            m = l + (r-l)/2;
            if (arr[m] == x) {
                return true;
            }
            if (arr[m] < x) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return false;
    }

}
