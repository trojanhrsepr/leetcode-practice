package tpr.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class DP {
    public boolean isPalindrome(int l, int r, String s, boolean[][] dp) {
        if(l > r) {
            return false;
        }
        if(dp[l][r]) {
            return dp[l][r];
        } else {
            if(s.charAt(l) == s.charAt(r) && isPalindrome(l+1, r-1, s, dp)) {
                dp[l][r] = true;
                return true;
            }
            return false;
        }
    }

    /**
     * Given a string s, return the longest
     * palindromic
     *
     * substring
     *  in s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 1000
     * s consist of only digits and English letters.
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1) {
            return s;
        }
        if(len == 2) {
            if(s.charAt(0) == s.charAt(1))
                return s;
            else
                return s.substring(0,1);
        }


        boolean[][] dp = new boolean[len][len];
        for(int i=0; i< len; i++) {
            for(int j=0; j< len; j++) {
                if(i==j) {
                    dp[i][j] = true;
                } else if(j - i == 1 && s.charAt(j) == s.charAt(i)) {
                    dp[i][j] = true;
                }
            }
        }

        String ans = "";
        for(int i=0; i< s.length(); i++) {
            for(int j=i; j< s.length(); j++) {
                if(isPalindrome(i,j,s,dp)) {
                    if(j-i+1 > ans.length()) {
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }

        return ans;
    }

    /**
     * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
     *
     * Given an integer n, return the nth ugly number.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 10
     * Output: 12
     * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
     */
    class Solution {
        public int nthUglyNumber(int n) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            int l2 = 0;
            int l3 = 0;
            int l5 = 0;

            int i = 0;
            while(list1.size() <= n) {
                int next = Math.min(list1.get(l2) * 2, list1.get(l3) * 3);
                next = Math.min(next, list1.get(l5) * 5);
                if(next == list1.get(l2) * 2)
                    l2++;
                else if(next == list1.get(l3) * 3)
                    l3++;
                else
                    l5++;
                if(!list1.contains(next))
                    list1.add(next);
            }

            return list1.get(n-1);
        }
    }
}
