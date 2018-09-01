//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//        Note:
//
//        The number of elements initialized in nums1 and nums2 are m and n respectively.
//        You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//        Example:
//
//        Input:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        Output: [1,2,2,3,5,6]


package leetcode.arrays;

public class MergeSortedArray {


    static public void merge(int[] array1, int m, int[] array2, int n) {

        int length1 = m - 1;
        int length2 = n - 1;
        int k = m + n - 1;
        while (length1 >= 0 && length2 >= 0) {
            if (array1[length1] > array2[length2]) {
                array1[k--] = array1[length1--];
            } else {
                array1[k--] = array2[length2--];
            }
        }
        while (length2 >= 0) {
            array1[k--] = array2[length2--];

        }
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);

        }
    }

    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 0, 0, 0};
        int[] array2 = {2, 5, 6};
        merge(array1, 3, array2, 3);


    }
}
