package twopointers;

public class PairWithTargetSum {


    public static int[] search(int[] arr, int targetSum) {
        int i = 0;
        int j = arr.length - 1;

        int check = arr[i] + arr[j];

        while (check != targetSum) {
            if (check < targetSum) {
                i = i + 1;
            } else {
                j = j - 1;
            }
            check = arr[i] + arr[j];
        }

        // TODO: Write your code here
        return new int[] { i, j };
    }



    public static void main(String[] args) {
        int[] input = new int[] { 1, 2, 3, 4, 6 };
        int target = 6;

        int[] search = search(input, target);
        System.out.println("Test");





    }

}
