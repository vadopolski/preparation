package binarysearch;

public class Imtro {

    /**
     * public static int search(int[] arr, int key) {
     *     if (arr.length == 0) return -1;
     *     return binarySearch(arr, key, 0, arr.length - 1, arr[0] <= arr[arr.length - 1]);
     *   }
     *
     *   private static int binarySearch(int[] arr, int key, int start, int end, boolean asc) {
     *
     *  Input: [4, 6, 10], key = 10
     *  Output: 2
     *
     *  binarySearch([4, 6, 10], 10, 0, 2, true)
     *  mid = 1
     *  binarySearch([4, 6, 10], 10, 2, 2, true)
     *  mid = 2 + 0 = 1

     *
     *  Input: [1, 2, 3, 4, 5, 6, 7], key = 5
     *  Output: 4
     *
     *
     *  Input: [10, 6, 4], key = 10
     *  Output: 0
     *
     *  Input: [10, 6, 4], key = 4
     *  Output: 2

    * */
    public static int search(int[] arr, int key) {
        if (arr.length == 0) return -1;
        return binarySearch(arr, key, 0, arr.length - 1, arr[0] <= arr[arr.length - 1]);
    }

    private static int binarySearch(int[] arr, int key, int start, int end, boolean asc) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == key) return mid;
        else if (asc) {
            if (arr[mid] < key)
                return binarySearch(arr, key, mid + 1, end, asc);
            else
                return binarySearch(arr, key, start, mid - 1, asc);
        } else {
            if (arr[mid] > key)
                return binarySearch(arr, key, mid + 1, end, asc);
            else
                return binarySearch(arr, key, start, mid - 1, asc);
        }

    }

    public static void main(String[] args) {
//        System.out.println(Imtro.search(new int[] { 4, 6, 10 }, 10)); // 2
        System.out.println(Imtro.search(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(Imtro.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(Imtro.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(Imtro.search(new int[] { 10, 6, 4 }, 4));
    }



}
