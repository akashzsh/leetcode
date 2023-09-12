class Solution {
    private int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        root.val = pre = root.val + pre;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}