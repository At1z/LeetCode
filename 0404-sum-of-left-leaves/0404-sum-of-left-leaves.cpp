/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int sumOfLeftLeaves(TreeNode* root) {
        int curVal = 0;
        int res = dfs(root, curVal);
        return res;
    }
public:
    int dfs(TreeNode* root, int &res){
        if(!root){
            return res;
        }
        if(root->left && !root->left->left && !root->left->right){
            res += root->left->val;
        }
        int left = dfs(root->left, res);
        int right = dfs(root->right, left); 
        return  right;
    }
};