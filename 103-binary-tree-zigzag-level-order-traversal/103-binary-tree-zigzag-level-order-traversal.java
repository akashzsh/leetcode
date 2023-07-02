class Solution {
    public void zigzag(TreeNode root, List<List<Integer>> res) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            flag = !flag;
            int size = queue.size();
            List<Integer> ds = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if (flag) ds.add(0, queue.poll().val);
                else ds.add(queue.poll().val);
            }
            res.add(ds);
        }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        zigzag(root, res);
        return res;
    }
}