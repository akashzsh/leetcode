class Solution {
    public int[] processQueries(int[] queries, int m) {
        int len = queries.length;
        int[] res = new int[len];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= m; i++) list.add(i);
        for (int i = 0; i < len; i++) {
            int tmp = queries[i];
            int pos = list.indexOf(tmp);
            res[i] = pos;
            list.remove(pos);
            list.add(0, tmp);
        }
        return res;
    }
}