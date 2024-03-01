class Solution {
    public int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = traverse(node.left);
        
        if (left == -1) {
            return -1;
        }
        
        int right = traverse(node.right);
        
        if (right == -1) {
            return -1;
        }
        
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        
        return 1 + Math.max(left, right);
    }
    
    public boolean isBalanced(TreeNode root) {
        return traverse(root) != -1;
    }
}