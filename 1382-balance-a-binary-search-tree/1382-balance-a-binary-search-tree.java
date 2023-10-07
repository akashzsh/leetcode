class Solution {
    private void inOrder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        inOrder(root.left, inorder);
        inorder.add(root.val);
        inOrder(root.right, inorder);
    }
    
    private TreeNode build(int low, int high, List<Integer> inorder) {
        if (low > high) return null;
        int mid = low + ((high - low) >> 1);
        TreeNode cur = new TreeNode(inorder.get(mid));
        cur.left = build(low, mid - 1, inorder);
        cur.right = build(mid + 1, high, inorder);
        return cur;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        return build(0, inorder.size() - 1, inorder);
    }
}