class Solution {
    public int findDiameter(TreeNode node, int[] res) {
        if (node == null) return 0;
        int left = findDiameter(node.left, res);
        int right = findDiameter(node.right, res);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        findDiameter(root, res);
        return res[0];
    }
}