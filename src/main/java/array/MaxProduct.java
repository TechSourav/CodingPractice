package array;

// Given an integer array, find the maximum product of two integers in it.
public class MaxProduct {

    public static void main(String[] args) {
        int[] A = { -10, -3, -5, 9, -2 };

        findMaximumProduct(A);
    }

    // Appoach 1
    /*private static void findMaximumProduct(int[] arr) {
        int maxProd = 0;
        for (int i = 0; i<arr.length-1; i++) {
            for (int j = i+1; j<arr.length; j++) {
                int prod = arr[i] * arr[j];
                if (prod > maxProd) {
                    maxProd = prod;
                }
            }
        }
        System.out.println(maxProd);
    }*/

    // Approach 2
    private static void findMaximumProduct(int[] arr) {
        int n = arr.length;

        if (n == 2) {
            System.out.println(arr[0]*arr[1]);
        }
        if (n < 2) {
            System.out.println("No pairs exists");
            return;
        }

        int posa = Integer.MIN_VALUE;
        int posb = Integer.MIN_VALUE;

        int nega = Integer.MIN_VALUE;
        int negb = Integer.MIN_VALUE;

        for (int i =0; i<n; i++) {
            if (arr[i]>posa) {
                posb = posa;
                posa = arr[i];
            } else if(arr[i]>posb) {
                posb = arr[i];
            }

            if (arr[i] < 0 && Math.abs(arr[i])>Math.abs(nega)) {
                negb = nega;
                nega = arr[i];
            } else if(arr[i] < 0 && Math.abs(arr[i])>Math.abs(negb)) {
                negb = arr[i];
            }

        }

        if (nega * negb > posa * posb)
            System.out.println("Max product pair is {"
                + nega + ", " + negb + "}");
        else
            System.out.println("Max product pair is {"
                + posa + ", " + posb + "}");


    }

}
