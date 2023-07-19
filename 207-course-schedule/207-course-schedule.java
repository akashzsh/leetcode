class Solution {
    public boolean dfs(int node, int[] v, int[] pv, ArrayList<ArrayList<Integer>> adj) {
        v[node] = 1;
        pv[node] = 1;
        for (int i : adj.get(node)) {
            if (v[i] == 0) {
                if (dfs(i, v, pv, adj)) return true;
            } else if (pv[i] == 1) return true;
        }
        pv[node] = 0;
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] v = new int[numCourses];
        int[] pv = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (v[i] == 0) {
                if (dfs(i, v, pv, adj)) return false;
            }
        }
        return true;
    }
}