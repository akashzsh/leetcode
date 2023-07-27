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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) continue;
                int dr[] = {-1, 0, 1, 0}, dc[] = {0, 1, 0, -1};
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            int nrnum = nr * n + nc, rnum = r * n + c;
                            ds.unionBySize(nrnum, rnum);
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) continue;
                int dr[] = {-1, 0, 1, 0}, dc[] = {0, 1, 0, -1};
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k], nc = c + dc[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            set.add(ds.findUParent(nr * n + nc));
                        }
                    }
                }
                int tmp = 0;
                for (int i : set) tmp += ds.size.get(i);
                max = Math.max(max, tmp + 1);
            }
        }
        for (int cell = 0; cell < n * n; cell++) {
            max = Math.max(max, ds.size.get(ds.findUParent(cell)));
        }
        return max;
    }
}