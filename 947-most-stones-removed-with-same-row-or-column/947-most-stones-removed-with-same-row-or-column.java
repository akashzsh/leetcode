class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    
    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    
    int findUParent(int node) {
        if (node == parent.get(node)) return node;
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    void unionBySize(int u, int v) {
        int ulpU = findUParent(u), ulpV = findUParent(v);
        if (ulpU == ulpV) return;
        if (size.get(ulpU) < size.get(ulpV)) {
            parent.set(ulpU, ulpV);
            size.set(ulpV, size.get(ulpU) + size.get(ulpV));
        } else {
            parent.set(ulpV, ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int len = stones.length, m = 0, n = 0;
        for (int i = 0; i < len; i++) {
            m = Math.max(m, stones[i][0]);
            n = Math.max(n, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(m + n + 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int row = stones[i][0];
            int col = m + 1 + stones[i][1];
            ds.unionBySize(row, col);
            map.put(row, 1);
            map.put(col, 1);
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getKey() == ds.findUParent(it.getKey())) cnt++;
        }
        return len - cnt;
    }
}