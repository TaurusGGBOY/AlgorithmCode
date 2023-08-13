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
    int res;
    vector<int> vec;
    int maxPathSum(TreeNode* root) {
        vec.emplace_back(0);
        vec.emplace_back(0);

        res = root->val;
        dfs(root)[0];
        return res;
    }

    // [leftmax, rightmax]
    void dfs(TreeNode* node) {
        if (nullptr == node) {
            vec[0] = -100000000;
            vec[1] = -100000000;
        }
        auto left = dfs(node->left);
        auto right = dfs(node->right);

        vec[0] = max(max(left[0], left[1]), 0) + node->val;
        vec[1] = max(max(right[0], right[1]), 0) + node->val;
        res = max(res, vec[0] + vec[1] - node->val);
    }
};