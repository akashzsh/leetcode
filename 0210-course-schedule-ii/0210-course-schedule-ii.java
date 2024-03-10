class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] inDegree = new int[numCourses];
        
        for (ArrayList<Integer> cur : adj) {
            for (Integer el : cur) {
                inDegree[el]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        int[] schedule = new int[numCourses];
        int p = 0;
        
        while (!q.isEmpty()) {
            
            Integer cur = q.poll();
            schedule[p++] = cur;
            
            for (Integer neighbor : adj.get(cur)) {
                
                inDegree[neighbor]--;
                
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
                
            }
        }
        
        return p == numCourses ? schedule : new int[]{};
    }
}