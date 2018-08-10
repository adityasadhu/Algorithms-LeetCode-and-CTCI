import java.util.Arrays;

public class checkPermutation {
    static final int MAX_CHARS = 256;
     public boolean isPermutation(String str1, String str2){

        int length1 = str1.length();
        int length2 = str2.length();

        if(length1!=length2)
            return false;

        int[] isVisited1 = new int[MAX_CHARS];
        int[] isVisited2 = new int[MAX_CHARS];
        Arrays.fill(isVisited1, 0);
        Arrays.fill(isVisited2, 0);

        for (int i = 0; i<length1; i++){
            isVisited1[str1.charAt(i)]++;
            isVisited2[str2.charAt(i)]++;
        }

        for (int i = 0; i<isVisited1.length; i++){
            if(isVisited1[i] != isVisited2[i]){
                return false;
            }

        }
        return true;
    }

    public static void main (String args[]){
        checkPermutation checkPermutation = new checkPermutation();
        boolean result = checkPermutation.isPermutation("abcd", "dbac");
        System.out.println(result);

    }

}
