class Solution {
    public void getParents(TreeNode root, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                queue.offer(curr.left);
                parent.put(curr.left, curr);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                parent.put(curr.right, curr);
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        getParents(root, parent);
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(target);
        visited.put(target, true);
        int curr_dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (k == curr_dist) break;
            curr_dist++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && visited.get(curr.left) == null) {
                    queue.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent.get(curr) != null && visited.get(parent.get(curr)) == null) {
                    queue.offer(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            res.add(curr.val);
        }
        return res;
    }
}