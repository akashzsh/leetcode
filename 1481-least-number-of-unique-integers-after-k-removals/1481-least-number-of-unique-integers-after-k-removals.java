class Solution {
    public int findLeastNumOfUniqueInts(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());
        
        int removed = 0;
        
        while (!pq.isEmpty()) {
            removed += pq.peek();
            if (removed > k) {
                return pq.size();
            }
            pq.poll();
        }
        
        return 0;
    }
}