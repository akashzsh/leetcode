class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode join = current.left;
                while (join.right != null) join = join.right;
                join.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}