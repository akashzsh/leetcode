class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Deque<Integer> idx = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            idx.add(i);
        }
        
        Arrays.sort(deck);
        int[] order = new int[n];
        for (int cur : deck) {
            order[idx.pollFirst()] = cur;
            if (!idx.isEmpty()) {
                idx.add(idx.pollFirst());
            }
        }
        
        return order;
    }
}