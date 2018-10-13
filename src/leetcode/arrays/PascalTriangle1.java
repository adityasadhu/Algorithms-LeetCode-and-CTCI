package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle1 {

    static public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            System.out.println(row);
            allrows.add(new ArrayList<Integer>(row));
        }
        //System.out.println(allrows);
        return allrows;

    }


    public static void main(String[] args) {
        generate(4);
    }
}
