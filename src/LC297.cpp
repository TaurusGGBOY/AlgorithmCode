#include "string"
#include "sstream"
#include "queue"
#include <queue>

using namespace std;

//   struct TreeNode {
//       int val;
//       TreeNode *left;
//       TreeNode *right;
//       TreeNode(int x) : val(x), left(NULL), right(NULL) {}
//   };

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
    stringstream ss;
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        queue<TreeNode *> q;
        q.push(root);

        ss.clear();

        while (!q.empty()) {
            int sz = q.size();
            while(--sz >= 0) {
                TreeNode * node = q.front();
                q.pop();

                if (nullptr == node) {
                    ss << "n,";
                } else {
                    ss << node->val << ",";
                    q.push(node->left);
                    q.push(node->right);
                }
            }
        }
        cout << ss.str();
        return ss.str();
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        int index{0};
        TreeNode* root{nullptr};
        TreeNode* parent_nodes{nullptr};
        queue<TreeNode*> inserting_nodes;

        while (index < data.size()) {
            TreeNode* node{nullptr};

            if (data[index] != 'n') {
                int val = 0;
                int neg = 1;
                if (data[index] == '-') {
                    neg = -1;
                }
                while(data[index] != ',') {
                    val = val * 10 + data[index] - '0';
                    ++index;
                }
                ++index;

                val *= neg;
                node = new TreeNode(val);
            } else {
                index += 2;
            }

            if (nullptr == parent_nodes) {
                parent_nodes = node;
                if (nullptr == root) {
                    root = node;
                }
            } else {
                inserting_nodes.push(node);
            }

            if (inserting_nodes.size() >= 2) {
                parent_nodes->left = inserting_nodes.front();
                inserting_nodes.pop();
                parent_nodes->right = inserting_nodes.front();
                inserting_nodes.pop();
                parent_nodes = nullptr;
            }
        }
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));