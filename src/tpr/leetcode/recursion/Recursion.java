package tpr.leetcode.recursion;

public class Recursion {

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
    public boolean isPalindrome(String s) {
        for(int i=0; i< s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i -1)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindromeCalc(int l, int r, String s, String[][] dp) {
        if(l>r) {
            return "";
        }
        if(dp[l][r] != "") {
            return dp[l][r];
        } else {
            if(isPalindrome(s.substring(l, r+1))) {
                dp[l][r] = s.substring(l, r+1);
                return s.substring(l, r+1);
            } else {
                String s1 = longestPalindromeCalc(l+1, r, s, dp);
                String s2 = longestPalindromeCalc(l, r-1, s, dp);
                String ans = s1.length()>s2.length() ? s1: s2;
                dp[l][r] = ans;
                return ans;
            }
        }
    }

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


        String[][] dp = new String[len][len];
        for(int i=0; i< len; i++) {
            for(int j=0; j< len; j++) {
                if(i==j) {
                    dp[i][j] = s.substring(i, i+1);
                } else if(j - i == 1 && s.charAt(j) == s.charAt(i)) {
                    dp[i][j] = s.substring(i, j+1);
                }
                else {
                    dp[i][j] = "";
                }
            }
        }

        return longestPalindromeCalc(0, len-1, s, dp);
    }
}
