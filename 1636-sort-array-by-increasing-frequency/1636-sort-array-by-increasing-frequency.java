class CustomComparator implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
        int key1 = e1.getKey(), key2 = e2.getKey(), freq1 = e1.getValue(), freq2 = e2.getValue();
        if (freq1 < freq2) return -1;
        if (freq1 > freq2) return 1;
        if (key1 > key2) return -1;
        return 1;
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        CustomComparator c = new CustomComparator();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(c);
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.add(e);
        }
        int k = 0;
        while (!pq.isEmpty()) {
            int cnt = pq.peek().getValue();
            for (int i = 0; i < cnt; i++) {
                nums[k++] = pq.peek().getKey();
            }
            pq.poll();
        }
        return nums;
    }
}