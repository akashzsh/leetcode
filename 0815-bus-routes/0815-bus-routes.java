class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                adj.computeIfAbsent(routes[i][j], k -> new ArrayList<>()).add(i);
            }
        }
        
        HashSet<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i : adj.get(source)) {
            vis.add(i);
            q.add(i);
        }
        
        int busCount = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int stop : routes[cur]) {
                    if (stop == target) {
                        return busCount;
                    }
                    for (int next : adj.get(stop)) {
                        if (!vis.contains(next)) {
                            vis.add(next);
                            q.add(next);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}