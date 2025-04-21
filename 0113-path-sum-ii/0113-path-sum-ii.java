class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(root, targetSum, paths, new ArrayList<>(), 0);
        return paths;
    }

    public void dfs(TreeNode root, int target, List<List<Integer>> paths, List<Integer> curPath, int curSum) {
        if (root == null) return;

        curPath.add(root.val);
        curSum += root.val;

        if (root.left == null && root.right == null && curSum == target) {
            paths.add(new ArrayList<>(curPath)); 
        } else {
            dfs(root.left, target, paths, curPath, curSum);
            dfs(root.right, target, paths, curPath, curSum);
        }

        curPath.remove(curPath.size() - 1); 
    }
}
