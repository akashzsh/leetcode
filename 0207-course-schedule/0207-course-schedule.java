class Solution {
    
    // DFS APPROACH to detect cycle in a directed graph
    public boolean deadlock(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pv) {
        vis[node] = true;
        pv[node] = true;
        
        for (Integer neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (deadlock(neighbor, adj, vis, pv)) {
                    return true;
                }
            } else if (pv[neighbor]) {
                return true;
            }
        }
        
        pv[node] = false;
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        boolean vis[] = new boolean[numCourses], pv[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (deadlock(i, adj, vis, pv)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}