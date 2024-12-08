package tpr.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;

public class DFS {
    public int DFS(TreeNode root, int depth) {
        if(root != null) {
            depth++;
            if(root.left == null && root.right == null) {
                return depth;
            } else if(root.left == null && root.right != null){
                return DFS(root.right, depth);
            } else if(root.right == null && root.left != null) {
                return DFS(root.left, depth);
            } else {
                return Math.min(DFS(root.left, depth), DFS(root.right, depth));
            }
        } else {
            return depth;
        }
    }

    /**
     * Given a binary tree, find its minimum depth.
     *
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 2
     * Example 2:
     *
     * Input: root = [2,null,3,null,4,null,5,null,6]
     * Output: 5
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        return DFS(root, 0);
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
