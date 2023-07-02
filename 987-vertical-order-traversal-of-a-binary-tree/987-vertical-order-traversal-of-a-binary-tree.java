class Tuple {
    TreeNode node;
    int x;
    int y;
    
    Tuple(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public void solve(List<List<Integer>> res, TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.offer(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int x = t.x;
            int y = t.y;
            
            if (!map.containsKey(x)) map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y)) map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);
            
            if (node.left != null) queue.offer(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null) queue.offer(new Tuple(node.right, x + 1, y + 1));
        }
        for (TreeMap<Integer, PriorityQueue<Integer>> mp : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : mp.values()) {
                while(!pq.isEmpty()) res.get(res.size() - 1).add(pq.poll());
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        solve(res, root);
        return res;
    }
}