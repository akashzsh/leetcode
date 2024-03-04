class Solution {
    public boolean f(TreeNode root, long lb, long ub) {
        if (root == null) {
            return true;
        }
        
        if (root.val <= lb || root.val >= ub) {
            return false;
        }
        
        return f(root.left, lb, root.val) && f(root.right, root.val, ub);
    }
    
    public boolean isValidBST(TreeNode root) {
        return f(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}