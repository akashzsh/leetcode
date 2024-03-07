class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        
        while (true) {
            if (root != null) {
                stk.push(root);
                root = root.left;
            } else {
                if (stk.isEmpty()) {
                    break;
                }
                root = stk.pop();
                k--;
                if (k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
        
        return -1;
    }
}