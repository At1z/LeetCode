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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty()){
            int size = bfs.size();
            double curRes = 0;
            for(int i = 0; i < size; i++){
                TreeNode curNode = bfs.poll();
                curRes += (double)curNode.val;
                if(curNode.left != null){
                    bfs.add(curNode.left);
                }
                if(curNode.right != null){
                    bfs.add(curNode.right);
                }
            }
            res.add(curRes/size);
        }
        return res;
    }
}