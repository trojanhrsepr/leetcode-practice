package tpr.leetcode.map;

import java.util.HashMap;

public class Map {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * @param nums
     * @param target
     * @return
     */
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
