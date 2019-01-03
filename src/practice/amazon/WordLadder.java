package practice.amazon;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class WordLadder {

    static public int answer(String beginWord, String endWord, List<String> wordList) {

        /*Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int answer = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String s : reached) {
                for (int i = 0; i < s.length(); i++) {
                    char[] c = s.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        c[i] = j;
                        String check = new String(c);
                        if (wordList.contains(check)) {
                            toAdd.add(check);
                            wordList.remove(check);
                        }
                    }
                }
            }
            answer++;
            if (toAdd.size() == 0)
                return 0;
            reached = toAdd;
        }*/

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int answer = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(queue);
            while (size > 0) {
                String s = queue.poll();
                if (s.equals(endWord)) {
                    return answer;
                }
                for (int i = 0; i < s.length(); i++) {
                    char[] temp = s.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (temp[i] != j) {
                            temp[i] = j;
                        }
                        String check = new String(temp);
                        if (check.equals(endWord) && wordList.contains(endWord)) {
                            answer++;
                            return answer;
                        }
                        if (wordList.contains(check)) {
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }
                }
                size--;
            }
            answer++;
        }
        return 0;
    }

    public static void main(String[] args) {

        System.out.println(answer("hit", "log", Arrays.stream(new String[]{"hot", "dot", "dog", "lot", "log"}).collect(Collectors.toList())));

    }
}
