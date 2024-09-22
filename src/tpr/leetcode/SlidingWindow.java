package tpr.leetcode;

import java.util.HashMap;

public class SlidingWindow {
    /**
     * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     * Example 3:
     *
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums.length > 0) {
            map.put(nums[0], 0);
            for(int i=1; i < nums.length; i++) {
                if(map.containsKey(nums[i])) {
                    if(i - map.get(nums[i]) <= k) {
                        return true;
                    } else {
                        map.put(nums[i], i);
                    }
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }

    /**
     * Given a string s, find the length of the longest
     * substring
     *  without repeating characters.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringWithoutSlidingWindow(String s) {
        int len = 0;
        char[] str = s.toCharArray();
        for (int i=0; i< s.length(); i++) {
            StringBuilder string = new StringBuilder();
            for(int j=0; j< s.length() - i; j++) {
                if(string.toString().indexOf(str[i+j]) == -1) {
                    string.append(str[i+j]);
                } else {
                    break;
                }
            }
            if(string.length() > len) {
                len = string.length();
            }
        }
        return len;
    }

    public int lengthOfLongestSubstringWithSlidingWindow(String s) {
        int len = 0;
        int maxSize = 0;
        char[] str = s.toCharArray();
        String finalStr = "";
        int i = 0;
        int j = 0;
        StringBuilder string = new StringBuilder();
        while(i < s.length() && j < s.length()) {
            while(j< s.length()) {
                if(string.toString().indexOf(str[j]) == -1) {
                    string.append(str[j]);
                    if(finalStr.length() < string.toString().length()) {
                        finalStr = string.toString();
                    }
                    j++;
                } else {
                    break;
                }
            }
            string.delete(0,1);
            i++;
        }
        return finalStr.length();
    }

    /**
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     *
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     */

    public int maxArea(int[] height) {
        int size = height.length;
        int maxArea = 0;
        int x;
        int y;
        for(int i=0; i<size; i++) {
            for(int j=i; j<size; j++) {
                if(i == j)
                    continue;
                int area;
                x = height[i];
                y = height[j];
                if(x > y) {
                    area = (x - (x-y)) * (j - i);
                } else {
                    area = (y - (y-x)) * (j - i);
                }
                if(area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    //2 Pointer/ Sliding Window:
    public int maxAreaSlidingWindow(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length -1;
        int area;
        while(left<right) {
            area = (right - left) * (Math.min(height[left], height[right]));
            if(maxArea < area) {
                maxArea = area;
            }
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
