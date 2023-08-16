class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        res.add(nums[q.peekFirst()]);
        for (int i = k; i < len; i++) {
            if (q.peekFirst() == i - k) q.pollFirst();
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
            res.add(nums[q.peekFirst()]);
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}