class Solution {
    int result = 0;
    
    private void calculate(ArrayList<ArrayList<Integer>> adj, int cur, int[] informTime, int time) {
        result = Math.max(result, time);
        for (int neighbor : adj.get(cur)) {
            calculate(adj, neighbor, informTime, informTime[cur] + time);
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) adj.get(manager[i]).add(i);
        }
        calculate(adj, headID, informTime, 0);
        return result;
    }
}