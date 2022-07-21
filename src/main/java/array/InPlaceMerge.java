package array;

import java.util.Arrays;

public class InPlaceMerge {

    public static void main(String[] args) {
        int[] X = { 1, 4, 7, 8, 10 };
        int[] Y = { 2, 3, 9 };

        merge(X, Y);

        System.out.println("X: " + Arrays.toString(X));
        System.out.println("Y: " + Arrays.toString(Y));
    }


    private static void merge(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;

        for (int i =0; i<m; i++) {
            if (X[i] > Y[0]) {
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;

                for (int k = 0; k < n - 1; k++) {
                    if (Y[k] > Y[k + 1]) {
                        int temp2 = Y[k];
                        Y[k] = Y[k + 1];
                        Y[k + 1] = temp2;
                    }
                }
            }
        }
    }

}
