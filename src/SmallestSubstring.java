import java.util.Arrays;

public class SmallestSubstring {


    static final int MAX_CHARS = 256;

    // Function to find smallest window containing
    // all distinct characters
    public String findSubString(String str)
    {
        int n = str.length();

        // Count all distinct characters.
        int countDistinctChars = 0;

        boolean[] visited = new boolean[MAX_CHARS];
        Arrays.fill(visited, false);
        for (int i=0; i<n; i++)
        {
            if (visited[str.charAt(i)] == false)
            {
                visited[str.charAt(i)] = true;
                countDistinctChars++;
            }
        }

        // Now follow the algorithm discussed in below
        // post. We basically maintain a window of characters
        // that contains all characters of given string.
        // https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
        int start = 0;
        int start_index = -1;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int[] currentCount =  new int[MAX_CHARS];
        for (int j=0; j<n; j++)
        {
            // Count occurrence of characters of string
            currentCount[str.charAt(j)]++;

            // If any distinct character matched,
            // then increment count
            if (currentCount[str.charAt(j)] == 1 )
                count++;

            // if all the characters are matched
            if (count == countDistinctChars)
            {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while (currentCount[str.charAt(start)] > 1)
                {
                    if (currentCount[str.charAt(start)] > 1)
                        currentCount[str.charAt(start)]--;
                    start++;
                }

                // Update window size
                int windowLength = j - start + 1;
                if (minLength > windowLength)
                {
                    minLength = windowLength;
                    start_index = start;
                }
            }
        }
        // Return substring starting from start_index
        // and length min_len
        return str.substring(start_index, start_index+minLength);
    }

    // Driver code
    public static void main(String args[])
    {
        SmallestSubstring smallestSubstring = new SmallestSubstring();
        String str = "abbbca";
        System.out.println("Smallest window containing all distinct"
                + " characters is " + smallestSubstring.findSubString(str).length()+ " " +smallestSubstring.findSubString(str));
    }
}
