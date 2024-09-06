package tpr.leetcode.tree;

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
}
