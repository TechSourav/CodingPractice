package array;

// Check if two arrays are permutations of each other.
public class CheckPermutation {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,1,2,9,4};

        int sum1 = 0;
        int sum2 = 0;
        int mul1 = 1;
        int mul2 = 1;

        for (int i = 0 ; i < arr1.length; i++) {
            sum1 += arr1[i];
            sum2 += arr2[i];
            mul1 *= arr1[i];
            mul2 *= arr2[i];
        }

        if (sum1 == sum2 && mul1 == mul2) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

}
