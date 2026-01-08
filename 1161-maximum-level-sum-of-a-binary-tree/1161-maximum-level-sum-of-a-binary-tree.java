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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        int[] maxLevel = new int[]{Integer.MIN_VALUE, 1};
        int index = 1;
        while(!bfs.isEmpty()){
            List<TreeNode> curNodes = new ArrayList<>();
            while(!bfs.isEmpty()){
                curNodes.add(bfs.poll());
            }
            int curValue = 0;
            for(TreeNode curNode : curNodes){
                curValue += curNode.val;
                if(curNode.left != null){
                    bfs.add(curNode.left);
                }
                if(curNode.right != null){
                    bfs.add(curNode.right);
                }
            }
            if(maxLevel[0] < curValue){
                maxLevel[0] = curValue;
                maxLevel[1] = index;
            }
            index++;
        }

        return maxLevel[1];
    }
}