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
    private int[] levelSums = new int[100000];
    public TreeNode replaceValueInTree(TreeNode root) {
        sumAtLevels(root,0);
        newTree(root,0,0);
        return root;
    }
    private void sumAtLevels(TreeNode node, int level) {
        if (node == null) {
            return;  
        }
        levelSums[level] += node.val;
        sumAtLevels(node.left, level + 1);
        sumAtLevels(node.right, level + 1);
    }
    private void newTree(TreeNode node, int sib, int level) {
        if (node == null) {
            return;
        }
        int sibleft = (node.left == null) ? 0 : node.left.val;
        int sibright = (node.right == null) ? 0 : node.right.val;
        if(level <= 1){
            node.val = 0;
        }else{
            node.val = levelSums[level] - node.val - sib;
        }
        newTree(node.left,sibright,level+1);
        newTree(node.right,sibleft,level+1);
    }
}