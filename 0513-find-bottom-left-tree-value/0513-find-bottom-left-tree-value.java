class Solution {
    public void traverse(TreeNode node, int level, int[] res) {
        if (node == null) {
            return;
        }
        if (res[0] < level) {
            res[0] = level;
            res[1] = node.val;
        }
        traverse(node.left, level + 1, res);
        traverse(node.right, level + 1, res);
    }
    
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[2];
        res[0] = 0;
        res[1] = root.val;
        traverse(root, 0, res);
        return res[1];
    }
}