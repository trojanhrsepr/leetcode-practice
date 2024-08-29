package tpr.leetcode;

import java.util.HashMap;

public class Map {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                if(i > map.get(target - nums[i])) {
                    return new int[] {map.get(target - nums[i]), i};
                } else {
                    return new int[] {i, map.get(target - nums[i])};
                }
            }
        }
        return null;
    }
}
