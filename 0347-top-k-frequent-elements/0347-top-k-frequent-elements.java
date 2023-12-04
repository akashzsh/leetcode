class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(new int[]{entry.getValue(), entry.getKey()});
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[pq.size()];
        k = 0;
        while (!pq.isEmpty()) {
            res[k++] = pq.poll()[1];
        }
        return res;
    }
}