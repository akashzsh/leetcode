class Tuple {
    TreeNode node;
    int vertical;
    int level;
    
    Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

class Solution {
    public void traverse(TreeNode root, List<List<Integer>> res) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            
            if (!map.containsKey(t.vertical)) {
                map.put(t.vertical, new TreeMap<>());
            }
            
            if (!map.get(t.vertical).containsKey(t.level)) {
                map.get(t.vertical).put(t.level, new PriorityQueue<>());
            }
            
            map.get(t.vertical).get(t.level).add(t.node.val);
            
            if (t.node.left != null) {
                q.add(new Tuple(t.node.left, t.vertical - 1, t.level + 1));
            }
            
            if (t.node.right != null) {
                q.add(new Tuple(t.node.right, t.vertical + 1, t.level + 1));
            }
        }
        
        for (TreeMap<Integer, PriorityQueue<Integer>> entry : map.values()) {
            List<Integer> vec = new ArrayList<>();
            for (PriorityQueue<Integer> cur : entry.values()) {
                while (!cur.isEmpty()) {
                    vec.add(cur.poll());
                }
            }
            res.add(vec);
        }
    }
       
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }
}