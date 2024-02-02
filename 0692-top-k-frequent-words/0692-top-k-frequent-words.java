class Pair {
    String word;
    int freq;
    
    Pair(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}

class CustomComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.freq != p2.freq) {
            return p1.freq - p2.freq;
        }
        String word1 = p1.word;
        String word2 = p2.word;
        return word2.compareTo(word1);
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        }
        CustomComparator c = new CustomComparator();
        PriorityQueue<Pair> pq = new PriorityQueue<>(c);
        for (Map.Entry<String, Integer> cur : freq.entrySet()) {
            Pair p1 = new Pair(cur.getKey(), cur.getValue());
            if (pq.size() >= k) {
                if (c.compare(p1, pq.peek()) > 0) {
                    pq.poll();
                } else {
                    continue;
                }
            }
            pq.add(p1);
        }
        List<String> res = new ArrayList<>();
        n = pq.size();
        for (int i = 0; i < n; i++) {
            res.add(0, pq.poll().word);
        }
        return res;
    }
}