package binarysearch;

public class CeilingNumber {

    /**
     * Input: [4, 6, 10], key = 6
     * Output: 1
     * Explanation: The smallest number greater than or equal to '6' is '6' having index '1'.
     *
     *
     *
     * Input: [1, 3, 8, 10, 15], key = 12
     * Output: 4
     * Explanation: The smallest number greater than or equal to '12' is '15' having index '4'.
     *
     *  arr = [1, 3, 8, 10, 15]
     *  order_asc = true
     *  key = 12
     *  start = 0
     *  end = 4
     *  mid = 2
     *  arr[2] = 8
     *  key = 12 > 8
     *  min = 8
     *
     *  arr = [1, 3, 8, 10, 15]
     *  order_asc = true
     *  key = 12
     *  start = 3
     *  end = 4
     *  mid = 3
     *  arr[3] = 10
     *  key = 12 > 10
     *  min = 3 arr[]
     *
     *  key = 12
     *  start = 4
     *  end = 4
     *  mid = 4
     *  arr[4] = 15
     *  key = 12 < 15
     *  min = 3 arr[]
     *
     *
     * */

}
