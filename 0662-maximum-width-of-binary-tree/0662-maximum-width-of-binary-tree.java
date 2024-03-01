class Pair {
    TreeNode node;
    int idx;
    
    Pair(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            int minimum = q.peek().idx;
            
            int first = -1;
            int last = -1;
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                
                if (i == 0) {
                    first = cur.idx;
                }
                
                if (i == size - 1) {
                    last = cur.idx;
                }
                
                cur.idx = cur.idx - minimum;
                
                if (cur.node.left != null) {
                    q.add(new Pair(cur.node.left, 2 * cur.idx + 1));
                }
                
                if (cur.node.right != null) {
                    q.add(new Pair(cur.node.right, 2 * cur.idx + 2));
                }
            }
            
            res = Math.max(res, last - first + 1);
        }
        
        return res;
    }
}