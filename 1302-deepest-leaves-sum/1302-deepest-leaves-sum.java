class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0, i = 0;
        while (!queue.isEmpty()) {
            for (i = queue.size() - 1, res = 0; i >= 0; i--) {
                TreeNode curr = queue.poll();
                if (curr.right != null) queue.offer(curr.right);
                if (curr.left != null) queue.offer(curr.left);
                res += curr.val;
            }
        }
        return res;
    }
}