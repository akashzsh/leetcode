class Solution {
    public boolean isBipartite(int node, int[] color, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i : adj.get(curr)) {
                if (color[i] == -1) {
                    color[i] = 1 - color[curr];
                    q.offer(i);
                } else if (color[i] == color[curr]) return false;
            }
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < len; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] color = new int[len];
        for (int i = 0; i < len; i++) color[i] = -1;
        for (int i = 0; i < len; i++) {
            if (color[i] == -1) {
                if (!isBipartite(i, color, adj)) return false;
            }
        }
        return true;
    }
}