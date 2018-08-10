import java.net.Inet4Address;
import java.util.Arrays;

public class SmallestSubstringTest {


    static final int MAX_CHARS = 256;
    public String subString(String str) {
        int length = str.length();
        int distinctChars = 0;
        boolean[] visited = new boolean[MAX_CHARS];
        Arrays.fill(visited, false);
        for (int i = 0; i < length; i++) {
            if(visited[str.charAt(i)] == false){
                visited[str.charAt(i)] = true;
                distinctChars++;
            }

        }

        int start = 0;
        int startIndex = 0;
        int[] currentCount = new int[MAX_CHARS];
        int count = 0;
        int minLength = 0;

        for (int i = 0; i < length; i++) {
            currentCount[str.charAt(i)]++;
            if(currentCount[str.charAt(i)] == 1){

                count++;
            }

            if(count == distinctChars){
                while(currentCount[str.charAt(start)] > 1){
                    if(currentCount[str.charAt(start)] > 1){
                        currentCount[str.charAt(start)] -- ;

                    }
                    start++;
                }

                int windowLength = start - i +1;
                if(minLength>windowLength){
                    minLength = windowLength;
                    startIndex = start;
                }
            }
        }
        return str.substring(startIndex, startIndex+minLength);
    }


    public static void main(String args[]) {
    SmallestSubstring smallestSubstring = new SmallestSubstring();
    String result = smallestSubstring.findSubString("abbbcb");
        System.out.println(result);
    }
}
