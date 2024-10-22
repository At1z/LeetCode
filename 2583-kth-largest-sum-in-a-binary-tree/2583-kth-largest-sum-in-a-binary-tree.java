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
import java.util.*;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSums = new ArrayList<>();
        sumAtLevels(root, levelSums, 0);
        Collections.sort(levelSums, Collections.reverseOrder());
        if (k > levelSums.size()) {
            return -1;
        }
        return levelSums.get(k - 1);
    }
    private void sumAtLevels(TreeNode node, List<Long> levelSums, int level) {
        if (node == null) {
            return;  
        }
        if (level >= levelSums.size()) {
            levelSums.add(0L);
        }
        levelSums.set(level, levelSums.get(level) + node.val);
        sumAtLevels(node.left, levelSums, level + 1);
        sumAtLevels(node.right, levelSums, level + 1);
    }
}
