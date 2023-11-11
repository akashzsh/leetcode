class Graph {
    int[][] adjMatrix;
    int n;
    
    public Graph(int N, int[][] edges) {
        n = N;
        adjMatrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = (int)(1e9);
            }
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            
            adjMatrix[u][v] = cost;
        }
        
        for (int i = 0; i < n; i++) {
            adjMatrix[i][i] = 0;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j],
                                               adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int cost = edge[2];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][u] + cost + adjMatrix[v][j]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return adjMatrix[node1][node2] == (int)(1e9) ? -1 : adjMatrix[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */