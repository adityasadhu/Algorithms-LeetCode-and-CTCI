//Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
//
//        The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
//
//        Example 1:
//        Input: "UD"
//        Output: true
//        Example 2:
//        Input: "LL"
//        Output: false

package leetcode.strings;

public class JudgeRouteCycle {


    static public boolean judgeCycle(String str){

        int length = str.length();

        int x = 0;
        int y = 0;

        for (int i = 0; i < length; i++) {
             switch (str.charAt(i)){
                 case 'R' : x++; break;
                 case 'L' : x--; break;
                 case 'U' : y++; break;
                 case 'D' : y--; break;
             }
        }
        if(x == 0 && y == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = judgeCycle("RLURDL");
        System.out.println(result);
    }

}
