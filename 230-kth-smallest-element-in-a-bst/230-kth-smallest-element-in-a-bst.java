class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int ans, cnt = 0;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                cnt++;
                if (cnt == k) return curr.val;
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) prev = prev.right;
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    cnt++;
                    if (cnt == k) return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}