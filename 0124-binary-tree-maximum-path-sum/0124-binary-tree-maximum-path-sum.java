class Solution {
    public int getMaxSum(TreeNode node, int[] res) {
        if (node == null) return 0;
        int left = Math.max(0, getMaxSum(node.left, res));
        int right = Math.max(0, getMaxSum(node.right, res));
        res[0] = Math.max(res[0], node.val + left + right);
        return node.val + Math.max(left, right);
    }
    
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        getMaxSum(root, res);
        return res[0];
    }
}