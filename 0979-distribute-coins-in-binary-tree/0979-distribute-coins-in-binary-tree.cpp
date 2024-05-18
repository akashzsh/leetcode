class Solution {
public:
    int f(TreeNode* node, int& res) {
        if (node == nullptr) {
            return 0;
        }
        
        int left = f(node->left, res);
        int right = f(node->right, res);
        
        res += abs(left) + abs(right);
        
        node->val += left + right - 1;
        
        return node->val;
    }
    
    int distributeCoins(TreeNode* root) {
        int res = 0;
        f(root, res);
        return res;
    }
};