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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty()){
            int size = bfs.size();
            for(int i = 0; i < size ; i++){
                TreeNode cur = bfs.poll();
                res.add(cur.val);
                if(cur.left != null){
                    bfs.add(cur.left);
                }
                if(cur.right != null){
                    bfs.add(cur.right);
                }
            }
        }
        Collections.sort(res);
        return res.get(k-1);
    }
}