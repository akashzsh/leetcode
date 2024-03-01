class Solution {
    public int traverse(TreeNode node, boolean[] res) {
        if (node == null) {
            return 0;
        }
        
        int left = traverse(node.left, res);
        int right = traverse(node.right, res);
        
        if (Math.abs(left - right) > 1) {
            res[0] = false;
        }
        
        return 1 + Math.max(left, right);
    }
    
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        traverse(root, res);
        return res[0];
    }
}