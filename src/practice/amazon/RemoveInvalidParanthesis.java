/*Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

        Note: The input string may contain letters other than the parentheses ( and ).

        Example 1:

        Input: "()())()"
        Output: ["()()()", "(())()"]
        Example 2:

        Input: "(a)())()"
        Output: ["(a)()()", "(a())()"]
        Example 3:

        Input: ")("
        Output: [""]*/

package practice.amazon;

import leetcode.strings.ValidParantheses;

import java.util.*;

public class RemoveInvalidParanthesis {


    static public List<String> answer(String digits) {
        ValidParantheses validParantheses = new ValidParantheses();

        HashSet<String> visited = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(digits);
        visited.add(digits);
        boolean found = false;

        while (!queue.isEmpty() && !found) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String check = queue.poll();
                if (validParantheses.isValid(check)) {
                    result.add(check);
                    found = true;
                }

                if (!found) {
                    int length = check.length();
                    for (int j = 0; j < length; j++) {
                        char c = check.charAt(i);
                        if (Character.isLetter(c)) {
                            continue;
                        }
                        String str = check.substring(0, j) + check.substring(j + 1);
                        if (!visited.contains(str)) {
                            queue.offer(str);
                            visited.add(str);
                        }
                    }

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(answer("(a)())()"));

    }
}
