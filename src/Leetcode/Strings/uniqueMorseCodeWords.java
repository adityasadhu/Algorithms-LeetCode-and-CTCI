//International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
//
//        For convenience, the full table for the 26 letters of the English alphabet is given below:
//
//        [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
//        Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
//
//        Return the number of different transformations among all words we have.
//
//        Example:
//        Input: words = ["gin", "zen", "gig", "msg"]
//        Output: 2
//        Explanation:
//        The transformation of each word is:
//        "gin" -> "--...-."
//        "zen" -> "--...-."
//        "gig" -> "--...--."
//        "msg" -> "--...--."
//
//        There are 2 different transformations, "--...-." and "--...--.".
//
//
//        Note:
//
//        The length of words will be at most 100.
//        Each words[i] will have length in range [1, 12].
//        words[i] will only consist of lowercase letters.


package Leetcode.Strings;

import java.util.HashSet;

public class uniqueMorseCodeWords {

    static public int answer(String[] words) {

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashSet<String> hashSet = new HashSet<>();

        for (String s : words) {
            char[] temp = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.length; i++) {
                sb.append(morse[temp[i] - 'a']);
            }
            hashSet.add(sb.toString());
        }

        return hashSet.size();
    }


    public static void main(String[] args) {

        System.out.println(answer(new String[]{"gin", "zen", "gig", "msg"}));

    }


}
