package array;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * link: https://leetcode.com/problems/3sum-closest/
 */

public class ThreeClosestSum {

    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        int target  = 1;
        /*System.out.println("Before sort");
        printArr(arr);
        Arrays.sort(arr);
        System.out.println("\n After sort");
        printArr(arr);*/ // -4,-1,1,2

        System.out.println(threeSumClosest(arr, target));
    }

    private static void printArr(final int[] arr) {
        for(int i =0; i<arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
    }

    public static int threeSumClosest(int[] arr, int target) {
        int n=arr.length;
        int ans=100000;

        Arrays.sort(arr);
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;

            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];

                if(sum==target){
                    return target;
                }

                if(Math.abs(target-sum)<Math.abs(target-ans)) {
                    ans=sum;
                }

                if(sum<target) {
                    left++;
                }
                if(sum>target) {
                    right--;
                }
            }
        }
        return ans;
    }

    // Zigzag order

    /*static List<Integer> ziggZagTraversal(Node root){
       Map<Integer,List<Integer>> map = new TreeMap<>();
       traverseInorder(map,root,0);
       List<Integer> output = new ArrayList<>();
       for(List<Integer> curList: map.values()){
           output.addAll(curList);
       }
       return output;
   }

   static void traverseInorder(Map<Integer,List<Integer>> map, Node root, int level){
       if(root != null){
           if(!map.containsKey(level)){
               map.put(level,new ArrayList<>());
           }
           List<Integer> cur = map.get(level);
           if(level %2 ==0){
               cur.add(0,root.val);
           }else{
               cur.add(root.val);
           }
           map.put(level,cur);
           traverseInorder(map,root.left,level+1);
           traverseInorder(map,root.right,level+1);
       }
   }*/

}
