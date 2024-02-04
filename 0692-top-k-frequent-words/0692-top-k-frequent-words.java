class CustomComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue() < e2.getValue()) return -1;
        if (e1.getValue() > e2.getValue()) return 1;
        if (e1.getKey().compareTo(e2.getKey()) < 0) return 1;
        return -1;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        }
        CustomComparator c = new CustomComparator();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(c);
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            pq.add(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }
        return res;
    }
}