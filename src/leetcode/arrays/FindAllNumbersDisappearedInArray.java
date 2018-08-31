//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
//
//        Find all the elements of [1, n] inclusive that do not appear in this array.
//
//        Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
//
//        Example:
//
//        Input:
//        [4,3,2,7,8,2,3,1]
//
//        Output:
//        [5,6]

package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedInArray {


    static public List<Integer> answer (int[] array){

        List<Integer> answer = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        for (int i = 1; i < array.length; i++) {
            if(!hashSet.contains(i)){
                answer.add(i);
            }
        }
        return answer;

    }

    public static void main(String[] args) {

        int[] array ={4,3,2,7,8,2,3,1};
        List<Integer> answer = answer(array);
        for(int i : answer){
            System.out.println(i);
        }

    }
}
