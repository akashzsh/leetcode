class Pair {
    long first;
    long second;
    
    Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        HashMap<Long, Long> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(b.first, a.first));
        
        long[] res = new long[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            
            Long x = (long)nums[i];
            Long y = (long)freq[i];
            
            map.put(x, map.getOrDefault(x, 0l) + y);
            pq.add(new Pair(map.get(x), x));
    
            while (pq.peek().first != map.getOrDefault(pq.peek().second, -1_000_000l)) {
                pq.poll();
            }
            
            res[i] = pq.peek().first;
        }
        
        return res;
    }
}