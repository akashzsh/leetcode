class Solution {
    public int check(TreeNode node) {
        if (node == null) return 0;
        int left = check(node.left);
        if (left == -1) return -1;
        int right = check(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
    
    public boolean isBalanced(TreeNode root) {
        if (check(root) == -1) return false;
        return true;
    }
}