package leetcode.strings;

import java.util.*;

public class TopKFrequentWords {


    static public List<String> answer(String[] words, int k) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : words) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            queue.offer(entry);
        }

        List<String> result = new ArrayList<>();

        while (queue.size() > k) {
            Map.Entry<String, Integer> temp = queue.poll();
            result.add(temp.getKey());
        }

        System.out.println(result);
        return result;
    }


    public static void main(String[] args) {

        answer(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);


    }
}
