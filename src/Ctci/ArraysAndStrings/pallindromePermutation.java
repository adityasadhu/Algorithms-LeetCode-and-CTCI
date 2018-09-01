package Ctci.ArraysAndStrings;

public class pallindromePermutation {

    static public boolean answer(String str) {

        int[] visited = new int[256];

        for (int i = 0; i < str.length(); i++) {
            visited[str.charAt(i)]++;
        }
        boolean foundOdd = false;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] % 2 == 1) {
                if(foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
