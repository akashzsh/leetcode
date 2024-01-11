class Solution {
    private int f(TreeNode root, int max, int min) {
        if (root == null) {
            return Math.abs(max - min);
        }
        
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        
        int left = f(root.left, max, min);
        int right = f(root.right, max, min);
        
        return Math.max(left, right);
    }
    
    public int maxAncestorDiff(TreeNode root) {
        return f(root, root.val, root.val);
    }
}