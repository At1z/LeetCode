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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    /*
        if(root == null){
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        if(root.right != null){
            newRoot.left = new TreeNode(root.right.val);
            leftSide(root.right, newRoot.left);
        }
        if(root.left != null){
            newRoot.right = new TreeNode(root.left.val);
            rightSide(root.left, newRoot.right);
        }
        return newRoot;
    }
    public void leftSide(TreeNode toor, TreeNode newRoot){
        if(toor.right != null){
            newRoot.left = new TreeNode(toor.right.val);
            leftSide(toor.right, newRoot.left);
        }
        if(toor.left != null){
            newRoot.right = new TreeNode(toor.left.val);
            leftSide(toor.left, newRoot.right);
        }
    }

    public void rightSide(TreeNode toor, TreeNode newRoot){
        if(toor.left != null){
            newRoot.right = new TreeNode(toor.left.val);
            rightSide(toor.left, newRoot.right);
        }
        if(toor.right != null){
            newRoot.left = new TreeNode(toor.right.val);
            rightSide(toor.right, newRoot.left);
        }
    }
    */
}