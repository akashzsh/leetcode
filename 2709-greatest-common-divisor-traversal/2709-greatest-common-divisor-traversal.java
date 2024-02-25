class DisjointSet {
    int[] size;
    int[] parent;
    int components;
    
    DisjointSet(int n) {
        size = new int[n];
        parent = new int[n];
        components = n;
        
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }
    
    int findUParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUParent(parent[node]);
    }
    
    void unionBySize(int u, int v) {
        int ulp_u = findUParent(u), ulp_v = findUParent(v);
        if (ulp_u == ulp_v) {
            return;
        }
        if (size[ulp_u] > size[ulp_v]) {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_v] += size[ulp_u];
        }
        
        components--;
    }
}


class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        DisjointSet ds = new DisjointSet(nums.length);
        
        int m = Arrays.stream(nums).max().orElse(0);
        int[] first = new int[m + 1];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < nums.length; i++) {
            int sqrt = (int) Math.sqrt(nums[i]);
            for (int j = 2; j <= sqrt; j++) {
                if (nums[i] % j != 0) {
                    continue;
                }
                
                if (first[j] != -1) {
                    ds.unionBySize(i, first[j]);
                } else {
                    first[j] = i;
                }
                
                while (nums[i] % j == 0) {
                    nums[i] = nums[i] / j;
                }
            }
            
            if (nums[i] > 1) {
                if (first[nums[i]] != -1) {
                    ds.unionBySize(i, first[nums[i]]);
                } else {
                    first[nums[i]] = i;
                }
            }
        }
        
        return ds.components == 1;
    }
}