package tpr.leetcode;

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
}
