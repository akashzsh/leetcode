class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return helper(root);
        TreeNode curr = root;
        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                } else curr = curr.left;
            } else {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                    break;
                } else curr = curr.right;
            }
        }
        return root;
    }
    
    public TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode lastRight = findLast(root.left);
        TreeNode rightChild = root.right;
        lastRight.right = rightChild;
        return root.left;
    }
    
    public TreeNode findLast(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }
}