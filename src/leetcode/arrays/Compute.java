

package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Compute {


    public int getNumOfCalls() {
        return numOfCalls;
    }

    private int numOfCalls = 0;

    public void answer(int maxPerWeek, int maxPerDay, int i, String hours, int count, String Pattern, List<String> result) {

        if (i > 6)
            return;

        if(count > maxPerWeek)
            return;

        if (i == 6) {
            if (hours.charAt(i) != '?') {
                if (maxPerWeek == count + Character.getNumericValue(hours.charAt(i))) {
                    Pattern += hours.charAt(i);
                    result.add(Pattern);
                }
            } else {
                if (maxPerWeek - count <= maxPerDay && maxPerWeek - count >= 0) {
                    Pattern += Integer.toString(maxPerWeek - count);
                    result.add(Pattern);

                }
            }

        }
        if (hours.charAt(i) != '?') {
            count += Character.getNumericValue(hours.charAt(i));
            Pattern += hours.charAt(i);
            answer(maxPerWeek, maxPerDay, i + 1, hours, count, Pattern, result);
            numOfCalls++;
        } else {
            for (int k = 0; k <= maxPerDay; k++) {
                answer(maxPerWeek, maxPerDay, i + 1, hours, count + k, Pattern + Integer.toString(k), result);
                numOfCalls++;
            }
        }
    }


    public static void main(String[] args) {

        Compute compute = new Compute();
        List<String> result = new ArrayList<>();
        compute.answer(3, 2, 0, "??2??000", 0, "", result);
        System.out.println(result);
        System.out.println(compute.getNumOfCalls());

    }
}

