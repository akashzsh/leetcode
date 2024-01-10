class Solution {
    private int res = 0;
    
    private int f(TreeNode root, int start) {
        int depth = 0;
        
        if (root == null) {
            return depth;
        }
        
        int leftDepth = f(root.left, start);
        int rightDepth = f(root.right, start);
        
        if (root.val == start) {
            res = Math.max(leftDepth, rightDepth);
            depth = -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = Math.max(leftDepth, rightDepth) + 1;
        } else {
            int cur = Math.abs(leftDepth) + Math.abs(rightDepth);
            res = Math.max(res, cur);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }
        return depth;
    }
    
    public int amountOfTime(TreeNode root, int start) {
        f(root, start);
        return res;
    }
}