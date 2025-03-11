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
    public int countNodes(TreeNode root) {
        int res = 0;
        if(root == null){
            return res;
        }
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty()){
            int size = bfs.size();
            for(int i = 0; i < size; i++){
                TreeNode curNode = bfs.poll();
                res += 1;
                if(curNode.left != null){
                    bfs.add(curNode.left);
                }
                if(curNode.right != null){
                    bfs.add(curNode.right);
                }
            }
        }
        return res;
    }
}