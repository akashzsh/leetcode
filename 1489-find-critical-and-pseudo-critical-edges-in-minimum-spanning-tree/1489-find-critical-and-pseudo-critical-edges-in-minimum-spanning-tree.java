class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    int count;
    
    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
        }
        count = n;
    }
    
    int findUParent(int node) {
        if (node == parent.get(node)) return node;
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    boolean unionBySize(int u, int v) {
        int ulpu = findUParent(u), ulpv = findUParent(v);
        if (ulpu != ulpv) {
            count--;
            parent.set(ulpu, ulpv);
            return true;
        } else {
            return false;
        }
    }
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len = edges.length;
        HashMap<int[], Integer> index = new HashMap<>();
        for (int i = 0; i < len; i++) index.put(edges[i], i);
        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));
        int minCost = MSTcost(n, edges, null, null);
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int[] curEdge = edges[i];
            int curEdgeIndex = index.get(curEdge);
            int withoutThis = MSTcost(n, edges, null, curEdge);
            if (withoutThis > minCost) {
                critical.add(curEdgeIndex);
            } else {
                int withThis = MSTcost(n, edges, curEdge, null);
                if (withThis == minCost) pseudo.add(curEdgeIndex);
            }
        }
        return Arrays.asList(critical, pseudo);
    }
    
    private int MSTcost(int n, int[][] edges, int[] pick, int[] skip) {
        int cost = 0;
        DisjointSet ds = new DisjointSet(n);
        int len = edges.length;
        
        if (pick != null) {
            ds.unionBySize(pick[0], pick[1]);
            cost += pick[2];
        }
        
        for (int i = 0; i < len; i++) {
            if (edges[i] != skip && ds.unionBySize(edges[i][0], edges[i][1])) {
                cost += edges[i][2];
            }
        }
        return ds.count == 1 ? cost : (int)(1e9);
    }
}