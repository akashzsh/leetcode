class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] mark = new int[n];
        for (List<Integer> cur : edges) {
            mark[cur.get(1)] = 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 0) res.add(i);
        }
        return res;
    }
}