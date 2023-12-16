class Solution {
    private void reverse(TreeNode node1, TreeNode node2, int curLevel) {
        if (node1 == null || node2 == null) {
            return;
        }
        if (curLevel % 2 != 0) {
            int el = node1.val;
            node1.val = node2.val;
            node2.val = el;
        }
        reverse(node1.left, node2.right, curLevel + 1);
        reverse(node1.right, node2.left, curLevel + 1);
    }
    
    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.left, root.right, 1);
        return root;
    }
}