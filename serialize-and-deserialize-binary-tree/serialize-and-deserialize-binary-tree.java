/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return ""; 

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            TreeNode cur = bfs.poll();
            if (cur == null) {
                sb.append("null").append(",");
                continue;
            }
            sb.append(cur.val).append(",");

            bfs.add(cur.left);
            bfs.add(cur.right);
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null; 

        String[] tree = data.split(",");
        int index = 0;

        TreeNode root = new TreeNode(Integer.parseInt(tree[index]));
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        index++;

        while (!bfs.isEmpty()) {
            TreeNode cur = bfs.poll();

            if (index < tree.length && !tree[index].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(tree[index]));
                bfs.add(cur.left);
            }
            index++;

            if (index < tree.length && !tree[index].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(tree[index]));
                bfs.add(cur.right);
            }
            index++;
        }

        return root;
    }
}

// Usage:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
