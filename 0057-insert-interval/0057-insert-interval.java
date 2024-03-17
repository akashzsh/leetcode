class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        
        int low = 0, high = intervals.length - 1;
        
        while (low <= high) {
            
            int mid = low + ((high - low) >> 1);
            
            if (intervals[mid][0] <= newInterval[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            
        }
        
        List<int[]> ls = new ArrayList<>();
        
        for (int i = 0; i < low; i++) {
            ls.add(intervals[i]);
        }
        
        ls.add(newInterval);
        
        for (int i = low; i < intervals.length; i++) {
            ls.add(intervals[i]);
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


// Linear search to find the insertion point

/*
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
*/