class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        
        for (int el : nums) {
            pq.add(el);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        
        while (pq.size() > k) {
            pq.poll();
        }
        
        return pq.peek();
    }
}