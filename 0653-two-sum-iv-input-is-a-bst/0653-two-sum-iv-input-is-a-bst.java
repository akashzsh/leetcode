class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        TreeNode cur = root;
        
        while (cur != null) {
            if (cur.left == null) {
                if (set.contains(k - cur.val)) {
                    return true;
                }
                set.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    if (set.contains(k - cur.val)) {
                        return true;
                    }
                    set.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        
        return false;
    }
}