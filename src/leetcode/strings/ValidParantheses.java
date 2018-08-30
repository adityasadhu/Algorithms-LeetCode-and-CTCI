package leetcode.strings;

import java.util.Stack;

public class ValidParantheses {


    static public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        char[] string = s.toCharArray();


        for (int i = 0; i < string.length; i++) {
            if(string[i] == '{' || string[i] == '[' || string[i] =='('){
                stack.push(string[i]);
            }else if(stack.isEmpty()){
                return false;
            }
            else if(string[i] == '}' && stack.peek() == '{'){
                stack.pop();
            }
            else if(string[i] == ']' && stack.peek() == '['){
                stack.pop();
            }
            else if(string[i] == ')' && stack.peek() == '('){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {

        String str = "{}[{}]";
        boolean answer = isValid(str);
        System.out.println(answer);

    }
}
