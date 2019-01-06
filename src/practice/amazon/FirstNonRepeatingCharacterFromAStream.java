package practice.amazon;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeatingCharacterFromAStream {

    private final static int MAX_CHARS = 256;

    static public void findFirstNonRepeating(String stream) {

        List<Character> list = new ArrayList<>();

        boolean[] repeated = new boolean[MAX_CHARS];

        int length = stream.length();

        for (int i = 0; i < length; i++) {
            char temp = stream.charAt(i);

            System.out.println("Reading " + temp + " from stream n");

            if(!repeated[temp]){
                if(!list.contains(temp)){
                    list.add(temp);
                }else {
                    list.remove((Character)temp);
                    repeated[temp] = true;
                }
            }

            if (list.size() != 0){
                System.out.println("first repeating element in stream is " + list.get(0));
            }

        }

    }

    public static void main(String[] args) {

        findFirstNonRepeating("geeksforgeeksandgeeksquizfor");

    }
}
