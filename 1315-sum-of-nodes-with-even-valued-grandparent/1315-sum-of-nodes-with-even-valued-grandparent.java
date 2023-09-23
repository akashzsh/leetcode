class Solution {
    private int sum(TreeNode node, int parent, int grandParent) {
        if (node == null) return 0;
        return sum(node.left, node.val, parent) + sum(node.right, node.val, parent) + (grandParent % 2 != 0 ? 0 : node.val);
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        return sum(root, -1, -1);
    }
}