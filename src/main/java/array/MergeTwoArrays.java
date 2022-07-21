package array;

import java.util.Arrays;

public class MergeTwoArrays {

    public static void main(String[] args) {
        int[] X = { 0, 2, 0, 3, 0, 5, 6, 0, 0 };
        int[] Y= { 1, 8, 9, 10, 15 };
        int j = 0;
        for (int i = 0; i < X.length; i++) {

            if (X[i] == 0) {
                X[i] = Y[j];
                j++;
            }
        }
        System.out.println("X: " + Arrays.toString(X));
    }

}
