class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        
        int[] inDegree = new int[n];
        for (int[] cur : relations) {
            int x = cur[0] - 1;
            int y = cur[1] - 1;
            adj.get(x).add(y);
            inDegree[y]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] maximum = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                maximum[i] = time[i];
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int neighbor : adj.get(cur)) {
                inDegree[neighbor]--;
                maximum[neighbor] = Math.max(maximum[neighbor], time[neighbor] + maximum[cur]);
                if (inDegree[neighbor] == 0) q.add(neighbor);
            }
        }
        
        int ans = 0;
        for (int i : maximum) {
            if (i > ans)
                ans = i;
        }
        
        return ans;
    }
}