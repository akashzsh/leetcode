class Solution {
    public int f(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            }
            return 0;
        }
        
        int res = 0;
        res += f(root.left, true);
        res += f(root.right, false);
        
        return res;
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        return f(root, false);
    }
}