class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : nums) {
            heap.add(i);
            if (heap.size() > k) heap.remove();
        }
        return heap.peek();
    }
}