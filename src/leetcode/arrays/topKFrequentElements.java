//Given a non-empty array of integers, return the k most frequent elements.
//
//        Example 1:
//
//        Input: nums = [1,1,1,2,2,3], k = 2
//        Output: [1,2]
//        Example 2:
//
//        Input: nums = [1], k = 1
//        Output: [1]
//        Note:
//
//        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

package leetcode.arrays;

import java.util.*;

public class topKFrequentElements {


    static public List<Integer> answer(int[] array, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        List<Integer>[] bucket = new List[array.length + 1];
        List<Integer> result = new ArrayList<>();

        for (int i : array) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        //bucketSort

//        for (int key : hashMap.keySet()) {
//            int frequency = hashMap.get(key);
//
//            if (bucket[frequency] == null) {
//                bucket[frequency] = new ArrayList<>();
//            }
//            bucket[frequency].add(key);
//        }
//
//        for (int pos = bucket.length - 1; pos >= 0 && result.size() < k; pos--) {
//            if (bucket[pos] != null) {
//                result.addAll(bucket[pos]);
//            }
//        }

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();

        for (int i : hashMap.keySet()) {
            int frequency = hashMap.get(i);

            if (!treeMap.containsKey(frequency)) {
                treeMap.put(frequency, new LinkedList<>());
            }
            treeMap.get(frequency).add(i);
        }

        while (result.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
            result.addAll(entry.getValue());
        }

        return result;
    }


    public static void main(String[] args) {

        int[] array = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3};
        List<Integer> answer = answer(array, 1);
        System.out.println(answer);



    }
}
