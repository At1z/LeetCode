/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        return dfs(root,1);
    }
    public int dfs(Node root, int level){
        if(root.children.size() == 0){
            return level;
        }
        int maxLevel = 0;
        for(Node child : root.children){
            maxLevel = Math.max(maxLevel, dfs(child,level + 1));
        }

        return maxLevel;
    }
}