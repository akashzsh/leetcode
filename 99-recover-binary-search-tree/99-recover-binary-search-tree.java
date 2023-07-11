class Solution {
    private TreeNode first;
    private TreeNode middle;
    private TreeNode second;
    private TreeNode prev;
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        first = middle = second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && second != null) {
            int txp = first.val;
            first.val = second.val;
            second.val = txp;
        } else {
            int txp = first.val;
            first.val = middle.val;
            middle.val = txp;
        }
    }
}