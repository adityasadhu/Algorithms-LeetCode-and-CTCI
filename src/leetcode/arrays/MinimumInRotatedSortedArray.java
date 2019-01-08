//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//        (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//
//        Find the minimum element.
//
//        You may assume no duplicate exists in the array.
//
//        Example 1:
//
//        Input: [3,4,5,1,2]
//        Output: 1
//        Example 2:
//
//        Input: [4,5,6,7,0,1,2]
//        Output: 0

package leetcode.arrays;

public class MinimumInRotatedSortedArray {


    static public int answer(int[] array) {

        int first = 0;
        int last = array.length - 1;

        if (array[last] >= array[first])
            return array[first];


        while (first <= last) {

            int mid = (first + last) / 2;

            if (array[mid] > array[mid + 1])
                return array[mid + 1];

            if (array[mid - 1] > array[mid])
                return array[mid];

            if (array[mid] > array[first]) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        return -1;

    }


    public static void main(String[] args) {


        int[] array = {3, 4, 5, 0, 1, 2};

        int answer = answer(array);

        System.out.println(answer);

    }
}
