class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> cur : freq.entrySet()) {
            pq.add(new int[]{cur.getValue(), cur.getKey()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        n = 0;
        int[] res = new int[pq.size()];
        while (!pq.isEmpty()) {
            res[n++] = pq.poll()[1];
        }
        return res;
    }
}