class Solution {
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> ans = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> cur : tickets) {
            map.computeIfAbsent(cur.get(0), k -> new PriorityQueue<>()).add(cur.get(1));
        }
        visit("JFK");
        return ans;
    }
    
    private void visit(String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            visit(map.get(airport).poll());
        }
        ans.add(0, airport);
    }
}