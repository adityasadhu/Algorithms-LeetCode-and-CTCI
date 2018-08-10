import java.util.Arrays;

public class isUnique {
    static final int MAX_CHARS = 256;
    public boolean isStringUnique(String str){
        boolean[] isVisited = new boolean[MAX_CHARS];
        Arrays.fill(isVisited, false);
        int length = str.length();

        for (int i = 0; i < length; i++) {
            if(isVisited[str.charAt(i)] == true){
                return false;
            }
            isVisited[str.charAt(i)] = true;
        }
        return true;
    }

    public static void main(String args[]){
        isUnique isUnique = new isUnique();
        boolean result = isUnique.isStringUnique("abcdefbba");
        System.out.println(result);
    }

}
