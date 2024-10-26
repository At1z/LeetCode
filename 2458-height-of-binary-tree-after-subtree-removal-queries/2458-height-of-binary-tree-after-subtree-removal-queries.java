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

To slow xd 
class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] level= new int[queries.length];
        for(int i = 0; i<queries.length; i++ ){
            level[i] = longestPath(root,queries[i],0)-1;
        }
        return level;
    }
    public int longestPath(TreeNode node, int query, int level){
        if (node == null || node.val == query) {
            return level;
        }
        int level1 = longestPath(node.right, query, level + 1);
        int level2 = longestPath(node.left, query, level + 1);
        return (Math.max(level1,level2));
    }
}

*/
class Solution {

    static final int[] heights = new int[100001];
    int maxHeight = 0;

    public int[] treeQueries(TreeNode root, int[] queries) {
        getLeftHeights(root, 0);
        maxHeight = 0;
        getRightHeights(root, 0);

        int n = queries.length;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            result[i] = heights[queries[i]];
        }

        return result;
    }

    private void getLeftHeights(TreeNode node, int height) {
        heights[node.val] = maxHeight;
        maxHeight = Math.max(maxHeight, height);
        if (node.left != null) getLeftHeights(node.left, height + 1);
        if (node.right != null) getLeftHeights(node.right, height + 1);
    }

    private void getRightHeights(TreeNode node, int height) {
        heights[node.val] = Math.max(heights[node.val], maxHeight);
        maxHeight = Math.max(height, maxHeight);
        if (node.right != null) getRightHeights(node.right, height + 1);
        if (node.left != null) getRightHeights(node.left, height + 1);
    }
}