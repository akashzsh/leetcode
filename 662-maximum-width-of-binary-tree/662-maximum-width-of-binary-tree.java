class Pair {
    TreeNode node;
    int num;
    
    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public int solve(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.peek().node;
                int currNum = queue.peek().num - min;
                queue.poll();
                if (i == 0) first = currNum;
                if (i == size - 1) last = currNum;
                if (curr.left != null) queue.offer(new Pair(curr.left, 2*currNum + 1));
                if (curr.right != null) queue.offer(new Pair(curr.right, 2*currNum + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        return solve(root);
    }
}