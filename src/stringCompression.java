
public class stringCompression {
    static final int MAX_CHARS = 26;
    public static void answer(String str){
        int visited[] = new int[MAX_CHARS];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            visited[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < visited.length; i++) {
            if(visited[i] != 0){
                System.out.print(Character.toString((char) (i +'a')) +""+ visited[i]);
            }

        }
    }

    public static void main(String args[]){
        answer("aabbcaa");

    }
}
