package tpr.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    /**
     * Given the root of a binary tree, return its maximum depth.
     *
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        int h = 0;
        queue.offer(root);
        while(queue.size() > 0) {
            int levelSize = queue.size();
            for(int i=0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if(visited.containsKey(cur)) {
                    // Cycle detected
                    return 0;
                } else {
                    visited.put(cur, true);
                    if(cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if(cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
            h++;
        }
        return h;
    }

    public int maxDepthStack(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int h = 0;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> heights = new LinkedList<Integer>();
        HashMap<TreeNode, Boolean> map = new HashMap<>();
        stack.add(root);
        heights.add(1);
        while(stack.size() > 0) {
            TreeNode val = stack.pollLast();
            if(!map.containsKey(val))
                map.put(val, true);
            else
                return 0;
            int height = heights.pollLast();
            if(val.left!=null) {
                stack.add(val.left);
                heights.add(height+1);
            }
            if(val.right!=null) {
                stack.add(val.right);
                heights.add(height+1);
            }
            if(h < height) {
                h = height;
            }
        }
        return h;
    }
}
