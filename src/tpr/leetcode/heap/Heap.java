package tpr.leetcode.heap;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Heap {
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> minHeapComparator = (a, b) -> b - a;
        PriorityQueue<Integer> queue = new PriorityQueue<>(minHeapComparator);
        if(Objects.isNull(nums) || nums.length < k || k < 0) {
            return 0;
        }
        for(int i=0; i< nums.length; i++) {
            queue.add(nums[i]);
        }
        int ans = 0;
        for(int i=0; i< k; i++) {
            ans = queue.poll();
        }
        return ans;
    }
}
