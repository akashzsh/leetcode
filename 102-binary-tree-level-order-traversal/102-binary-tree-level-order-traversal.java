class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currLevel = queue.size();
            List<Integer> ds = new LinkedList<>();
            for (int i = 0; i < currLevel; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                ds.add(queue.poll().val);
            }
            res.add(ds);
        }
        return res;
    }
}