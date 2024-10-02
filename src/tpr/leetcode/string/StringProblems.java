package tpr.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class StringProblems {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string s, int numRows);
     *
     *
     * Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for(int i=0; i< numRows; i++) {
            list.add(new StringBuilder());
        }

        boolean down = true;
        int ctr = 0;
        int size = s.length();
        int temp = 0;

        while(ctr < size) {
            list.get(temp).append(s.charAt(ctr));
            ctr++;
            if(numRows - 1 == temp) {
                down = false;
            } else if(temp == 0) {
                down = true;
            }
            if(down) {
                temp++;
            } else {
                temp--;
            }
        }

        for(int i=1; i<numRows; i++) {
            list.get(0).append(list.get(i).toString());
        }
        return list.get(0).toString();
    }
}
