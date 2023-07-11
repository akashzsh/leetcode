class Solution {
    public boolean check(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val <= minVal || root.val >= maxVal) return false;
        return check(root.left, minVal, root.val) && check(root.right, root.val, maxVal);
    }
    
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}