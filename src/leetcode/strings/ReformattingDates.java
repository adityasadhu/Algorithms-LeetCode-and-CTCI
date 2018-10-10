package leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReformattingDates {


    static public String[] answer(String[] dates) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> resultTemp = new ArrayList<>();

        hashMap.put("Jan", 1);
        hashMap.put("Feb", 2);
        hashMap.put("Mar", 3);
        hashMap.put("Apr", 4);
        hashMap.put("May", 5);
        hashMap.put("Jun", 6);
        hashMap.put("Jul", 7);
        hashMap.put("Aug", 8);
        hashMap.put("Sep", 9);
        hashMap.put("Oct", 10);
        hashMap.put("Nov", 11);
        hashMap.put("Dec", 12);

        for (String s : dates) {
            String[] temp = s.split(" ");
            StringBuilder innerResult = new StringBuilder();


            innerResult.append(temp[2]);
            innerResult.append("-");

            if (hashMap.get(temp[1]) < 10) {
                innerResult.append("0" + hashMap.get(temp[1]));
            } else {
                innerResult.append(hashMap.get(temp[1]));
            }

            innerResult.append("-");
            temp[0] = temp[0].replaceAll("\\D+", "");
            if (Integer.parseInt(temp[0]) < 10) {
                innerResult.append("0" + temp[0]);
            } else {
                innerResult.append(temp[0]);
            }

            resultTemp.add(innerResult.toString());
        }

        String[] result = resultTemp.toArray(new String[0]);
        return result;
    }


    public static void main(String[] args) {

        String[] dates = {"1st Mar 1984", "2nd Feb 2013", "4th Dec 1900"};
        String[] answer = answer(dates);
        for (String s : answer) {
            System.out.println(s);
        }


    }
}
