package tpr.leetcode.slidingwindow;

import java.util.HashMap;

public class SlidingWindow {
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
}
