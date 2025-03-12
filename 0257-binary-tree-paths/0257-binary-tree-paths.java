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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(root, new StringBuilder(), res);
        return res;
    }

    public void dfs(TreeNode root, StringBuilder cur, List<String> res){
        int len = cur.length();
        if(len == 0){
            cur.append(root.val);
        }else{
            cur.append("->").append(root.val);
        }
        if (root.left == null && root.right == null) {
            res.add(cur.toString());
        } else {
            if (root.left != null) {
                dfs(root.left, cur, res);
            }
            if (root.right != null) {
                dfs(root.right, cur, res);
            }
        }
        cur.setLength(len);
    }
}