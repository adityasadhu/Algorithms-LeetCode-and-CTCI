public class palindromePermutation {

    public static boolean check(String str){
        int length = str.length();
        int[] visited = new int[256];

        for (int i = 0; i < length; i++) {
             visited[str.charAt(i)]++;
        }
        boolean foundOdd = false;
        for (int j = 0; j<visited.length; j++){
            if (visited[j] % 2 == 1){
                if(foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

public static void main (String args[]){
        boolean result = check("tactcoa");
        System.out.println(result);
}

}
