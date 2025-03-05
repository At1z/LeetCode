/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return min(root, 1);
    }

    public int min(TreeNode root, int step){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.right == null && root.left == null){
            return step;
        }
        int left = min(root.left, step + 1);
        int right = min(root.right, step + 1);

        return Math.min(left,right);
    }
}