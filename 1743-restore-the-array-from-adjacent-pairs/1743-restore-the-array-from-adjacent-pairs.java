class Solution {
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    
    private void dfs(int root, int prev, int[] res, int idx) {
        res[idx] = root;
        for (int neighbor : adj.get(root)) {
            if (neighbor != prev) {
                dfs(neighbor, root, res, idx + 1);
            }
        }
    }
    
    public int[] restoreArray(int[][] adjacentPairs) {
        for (int[] cur : adjacentPairs) {
            int x = cur[0];
            int y = cur[1];
            
            if (!adj.containsKey(x)) {
                adj.put(x, new ArrayList<>());
            }
            
            if (!adj.containsKey(y)) {
                adj.put(y, new ArrayList<>());
            }
            
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int root = 0;
        for (int i : adj.keySet()) {
            if (adj.get(i).size() == 1) {
                root = i;
                break;
            }
        }
        int[] res = new int[adj.size()];
        dfs(root, Integer.MAX_VALUE, res, 0);
        return res;
    }
}