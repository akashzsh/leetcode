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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extra = 0, components = 0;
        for (int[] i : connections) {
            if (ds.findUParent(i[0]) != ds.findUParent(i[1])) {
                ds.unionBySize(i[0], i[1]);
            } else {
                extra++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == ds.findUParent(i)) components++;
        }
        if (extra >= components - 1) return components - 1;
        else return -1;
    }
}