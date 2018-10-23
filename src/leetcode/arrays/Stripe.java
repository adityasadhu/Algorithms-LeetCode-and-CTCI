package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Stripe {


    static public List<Integer> answer(List<String> array) {


        List<String> apis = new ArrayList<>();
        List<String> bals = new ArrayList<>();
        List<Integer> answerFinal = new ArrayList<>();

        double amount = 0;
        String driverAccount = "";
        String merchantAccount = "";
        double driverAmount = 0;

        double merchantAmount = 0;


        for (String s : array) {
            if (s.substring(0, 3).equals("API")) {
                apis.add(s.substring(5));
            } else if (s.substring(0, 3).equals("BAL")) {
                bals.add(s.substring(5));
            }
        }

        HashMap<String, Double> merchantHashMap = new HashMap<>();
        HashMap<String, Double> driverHashMap = new HashMap<>();
        HashMap<String, String> tempHashMap = new HashMap<>();

        for (String s : apis) {
            String[] temp = s.split("&");

            for (String st : temp) {
                String[] ini = st.split("=");
                tempHashMap.put(ini[0], ini[1]);
            }
            if (tempHashMap.containsKey("amount")) {
                amount = Double.parseDouble(tempHashMap.get("amount"));
            }
            if (tempHashMap.containsKey("destination[amount]")) {
                driverAmount = Double.parseDouble(tempHashMap.get("destination[amount]"));
            }
            if (tempHashMap.containsKey("destination[account]")) {
                driverAccount = tempHashMap.get("destination[account]");
            }
            if (tempHashMap.containsKey("merchant")) {
                merchantAccount = tempHashMap.get("merchant");
            }


            amount = amount / 100;
            driverAmount = driverAmount / 100;
            double stripeFee = ((amount * 2.9) / 100) + 0.30;


            merchantAmount = amount - stripeFee - driverAmount;

            if (!merchantHashMap.containsKey(merchantAccount)) {
                merchantHashMap.put(merchantAccount, merchantAmount);
            } else {
                merchantHashMap.put(merchantAccount, merchantHashMap.get(merchantAccount) + merchantAmount);
            }

            if (!driverHashMap.containsKey(driverAccount)) {
                driverHashMap.put(driverAccount, driverAmount);
            } else {
                driverHashMap.put(driverAccount, driverHashMap.get(driverAccount) + driverAmount);
            }
        }

        for (String te : bals) {

            String[] temp2 = te.split("=");

            if (driverHashMap.containsKey(temp2[1])) {
                int temp3 = (int) Math.round(driverHashMap.get(temp2[1]) * 100);
                answerFinal.add(temp3);
            } else if (merchantHashMap.containsKey(temp2[1])) {
                int temp3 = (int) Math.round(merchantHashMap.get(temp2[1]) * 100);
                answerFinal.add(temp3);
            }
        }


        System.out.println(answerFinal);
        return answerFinal;
    }


    public static void main(String[] args) {

        List<String> array = new ArrayList<>();
        array.add("API: amount=1000&merchant=123456789&destination[account]=111111&destination[amount]=877");
        array.add("API: amount=1000&merchant=123456788&destination[account]=111112&destination[amount]=879");
        array.add("BAL: merchant=123456789");
        array.add("BAL: merchant=123456788");

        array.add("BAL: merchant=111111");
        array.add("BAL: merchant=111112");
        answer(array);


    }
}
