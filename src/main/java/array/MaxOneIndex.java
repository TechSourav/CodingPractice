package array;

public class MaxOneIndex {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 1, 1, 1, 0, 1, 1};
        int maxCount = 0;
        int prevZeroIndex = -1;
        int maxIndex = -1;
        int count = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==1) {
                count++;
            } else {
                count = i - prevZeroIndex;
                prevZeroIndex = i;
            }
            if (count > maxCount) {
                maxCount = count;
                maxIndex = prevZeroIndex;
            }
        }
        System.out.println(maxIndex);
    }

}
