package practice.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordLadder {

    static public int answer(String beginWord, String endWord, List<String> wordList) {

        Set<String> reached = new HashSet<>();
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
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(answer("hit", "cog", Arrays.stream(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}).collect(Collectors.toList())));

    }
}
