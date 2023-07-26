class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();
                tmp.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            res.add(tmp);
        }
        Collections.reverse(res);
        return res;
    }
}