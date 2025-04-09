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
    void dfs(TreeNode* root, map<int,int>& frequency){
        if(root == nullptr){
            return;
        }
        frequency[root->val]++;

        dfs(root->left, frequency );
        dfs(root->right, frequency );
    }

    vector<int> findMode(TreeNode* root) {
        std::map<int,int> frequency;
        std::vector<int> res{0};
        dfs(root, frequency);
        for(auto& freq: frequency){
            cout << freq.first << endl;
        }
        int maxFreq = 0;
        for(auto& freq: frequency){
            if(maxFreq == freq.second){
                res.push_back(freq.first);
            }else if(maxFreq < freq.second){
                res.clear();
                maxFreq =  freq.second;
                res.push_back(freq.first);
            }
        }
        return res;
    }

};