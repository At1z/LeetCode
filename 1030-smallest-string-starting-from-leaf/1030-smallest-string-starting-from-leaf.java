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
    public String smallestFromLeaf(TreeNode root) {
        if(root == null){
            return "";
        }
        List<String> res = new ArrayList<>();
        backtracking(root, new StringBuilder(), res);
        return res.stream().sorted().findFirst().get();
    }
    public void backtracking(TreeNode root, StringBuilder curWord, List<String> res){
        curWord.append((char) ('a' + root.val));
        if(root.left == null && root.right == null){
            
            res.add(new StringBuilder(curWord).reverse().toString());
            return;
        }
        if(root.left != null){
            backtracking(root.left,curWord,res);
            curWord.setLength(curWord.length() - 1);
        }
        if(root.right != null){
            backtracking(root.right,curWord,res);
            curWord.setLength(curWord.length() - 1);
        }
        
    }
}