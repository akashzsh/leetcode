class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int n = order.length();
        
        for (int i = 0; i < n; i++) {
            map.put(order.charAt(i), i);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                int rank1 = map.getOrDefault(c1, 30);
                int rank2 = map.getOrDefault(c2, 30);
                
                return rank1 - rank2;
            }
        });
        
        for (char ch : s.toCharArray()) {
            pq.add(ch);
        }
        
        StringBuilder res = new StringBuilder();
        
        while (!pq.isEmpty()) {
            res.append(pq.poll());
        }
        
        return res.toString();
    }
}