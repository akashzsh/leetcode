class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {{newInterval[0], newInterval[1]}};
        }
        
        List<int[]> ls = new ArrayList<>();
        boolean done = false;
        
        for (int[] cur : intervals) {
            if (!done && cur[0] > newInterval[0]) {
                ls.add(new int[]{newInterval[0], newInterval[1]});
                done = true;
            }
            ls.add(new int[] {cur[0], cur[1]});
        }
        
        if (!done) {
            ls.add(new int[]{newInterval[0], newInterval[1]});
        }
        
        LinkedList<int[]> ll = new LinkedList<>();
        
        for (int[] it : ls) {
            if (ll.isEmpty() || ll.getLast()[1] < it[0]) {
                ll.add(new int[] {it[0], it[1]});
            } else {
                ll.getLast()[1] = Math.max(ll.getLast()[1], it[1]);
            }
        }
        
        return ll.toArray(new int[ll.size()][]);
    }
}