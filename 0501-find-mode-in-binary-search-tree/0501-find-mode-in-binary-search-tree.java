class Solution {
    public int[] findMode(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            count.put(cur.val, count.getOrDefault(cur.val, 0) + 1);
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        int max = 0, cnt = 0;
        for (int i : count.values()) {
            max = Math.max(max, i);
        }
        for (int i : count.values()) {
            if (i == max) {
                cnt++;
            }
        }
        int[] ans = new int[cnt];
        cnt = 0;
        for (int i : count.keySet()) {
            if (count.get(i) == max) {
                ans[cnt++] = i;
            }
        }
        return ans;
    }
}