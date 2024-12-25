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
    Map<Integer,Integer> maxVal = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0); 
        for (int i = 0; i < maxVal.size(); i++) {
            res.add(maxVal.get(i));
        }
    return res;
    }
    private void dfs(TreeNode node, int level){
        if(node == null){
            return;
        }
        maxVal.put(level, Math.max(maxVal.getOrDefault(level, Integer.MIN_VALUE), node.val));
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}