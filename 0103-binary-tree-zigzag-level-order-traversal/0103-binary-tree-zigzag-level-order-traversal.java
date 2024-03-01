class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int level = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            List<Integer> vec = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                vec.add(cur.val);
                
                if (cur.left != null) {
                    q.add(cur.left);
                }
                
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            
            if (level++ % 2 != 0) {
                Collections.reverse(vec);
            }
            
            res.add(new ArrayList<>(vec));
        }
        
        return res;
    }
}