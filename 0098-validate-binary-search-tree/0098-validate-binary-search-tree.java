class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Queue<NodeRange> queue = new LinkedList<>();
        queue.add(new NodeRange(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!queue.isEmpty()) {
            NodeRange current = queue.poll();
            TreeNode node = current.node;
            long min = current.min, max = current.max;

            if (node.val <= min || node.val >= max) return false;

            if (node.left != null) {
                queue.add(new NodeRange(node.left, min, node.val));
            }
            if (node.right != null) {
                queue.add(new NodeRange(node.right, node.val, max));
            }
        }
        return true;
    }

    private static class NodeRange {
        TreeNode node;
        long min, max;

        NodeRange(TreeNode node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
}
