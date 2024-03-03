class Solution {
    public boolean f(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        return f(p.left, q.right) && f(p.right, q.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        TreeNode p = root.left, q = root.right;
        return f(p, q);
    }
}