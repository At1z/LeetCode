class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int level = p.level;

            if (res.size() <= level) {
                res.add(new ArrayList<>());
            }
            if (level % 2 == 0) {
                res.get(level).add(node.val); 
            } else {
                res.get(level).add(0, node.val);
            }

            if (node.left != null) queue.add(new Pair(node.left, level + 1));
            if (node.right != null) queue.add(new Pair(node.right, level + 1));
        }

        return res;
    }
}
