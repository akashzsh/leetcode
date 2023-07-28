class Solution {
    public int solve(TreeNode node, int s) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.val + s * 10;
        return solve(node.left, node.val + s * 10) + solve(node.right, node.val + s * 10);
    }
    
    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }
}