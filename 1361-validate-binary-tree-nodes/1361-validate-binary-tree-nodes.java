class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Integer> childToParent = new HashMap<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];
            
            if (childToParent.containsKey(left)) return false;
            if (left != -1) {
                childToParent.put(left, i);
                adj.get(i).add(left);
            }
            
            if (childToParent.containsKey(right)) return false;
            if (right != -1) {
                childToParent.put(right, i);
                adj.get(i).add(right);
            }
        }
        
        int root = -1;
        
        for (int i = 0; i < n; i++) {
            if (!childToParent.containsKey(i)) {
                if (root != -1) return false;
                root = i;
            }
        }
        
        if (root == -1) return false;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        int cnt = 1;
        boolean[] vis = new boolean[n];
        
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int con : adj.get(node)) {
                if (vis[con]) return false;
                vis[con] = true;
                q.add(con);
                cnt++;
            }
        }
        
        return cnt == n;
    }
}