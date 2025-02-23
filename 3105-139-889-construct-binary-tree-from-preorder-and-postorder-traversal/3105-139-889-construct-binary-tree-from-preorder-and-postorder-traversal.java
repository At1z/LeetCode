class Solution {
    private Map<Integer, Integer> postIndexMap;
    private int preIndex = 0; 

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }

        return builder(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode builder(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if (preIndex >= preorder.length || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]); 

        if (postStart == postEnd) {
            return root; 
        }
        int leftChildIndex = postIndexMap.get(preorder[preIndex]);
        root.left = builder(preorder, postorder, postStart, leftChildIndex);
        root.right = builder(preorder, postorder, leftChildIndex + 1, postEnd - 1);

        return root;
    }
}
