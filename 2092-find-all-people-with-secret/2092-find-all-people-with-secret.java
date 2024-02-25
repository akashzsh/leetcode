class DisjointSet {
    int[] rank;
    int[] parent;
    
    DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    int findUParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUParent(parent[node]);
    }
    
    void unionByRank(int u, int v) {
        int ulp_u = findUParent(u), ulp_v = findUParent(v);
        if (ulp_u == ulp_v) {
            return;
        }
        if (rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        } else if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
    
    void reset(int node) {
        parent[node] = node;
        rank[node] = 0;
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        DisjointSet ds = new DisjointSet(n);
        
        ds.unionByRank(0, firstPerson);
        
        int i = 0;
        while (i < meetings.length) {
            int curTime = meetings[i][2];
            ArrayList<Integer> sameTimePeople = new ArrayList<>();
            
            while (i < meetings.length && meetings[i][2] == curTime) {
                ds.unionByRank(meetings[i][0], meetings[i][1]);
                sameTimePeople.add(meetings[i][0]);
                sameTimePeople.add(meetings[i][1]);
                i++;
            }
            
            for (int j : sameTimePeople) {
                if (ds.findUParent(j) != ds.findUParent(0)) {
                    ds.reset(j);
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (i = 0; i < n; i++) {
            if (ds.findUParent(i) == ds.findUParent(0)) {
                res.add(i);
            }
        }
        
        return res;
    }
}