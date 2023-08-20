class Solution {
    private List<Integer> topoSort(Map<Integer, List<Integer>> graph, int[] inDegree) {
        ArrayList<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) stack.push(i);
        }
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            visited.add(curr);
            for (int i : graph.get(curr)) {
                inDegree[i]--;
                if (inDegree[i] == 0) stack.push(i);
            }
        }
        return visited.size() == graph.size() ? visited : new ArrayList<>();
    }
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) group[i] = m++;
        }
        // Item Graph
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        for (int i = 0; i < n; i++) itemGraph.put(i, new ArrayList<>());
        int[] itemInDegree = new int[n];
        // Group Graph
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        for (int i = 0; i < m; i++) groupGraph.put(i, new ArrayList<>());
        int[] groupInDegree = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int before : beforeItems.get(i)) {
                itemGraph.get(before).add(i);
                itemInDegree[i]++;
                if (group[before] != group[i]) {
                    groupGraph.get(group[before]).add(group[i]);
                    groupInDegree[group[i]]++;
                }
            }
        }
        
        List<Integer> itemOrder = topoSort(itemGraph, itemInDegree);
        List<Integer> groupOrder = topoSort(groupGraph, groupInDegree);
        
        if (itemOrder.size() == 0 || groupOrder.size() == 0) return new int[0];
        
        Map<Integer, List<Integer>> ordered = new HashMap<>();
        for (int curr : itemOrder) {
            ordered.computeIfAbsent(group[curr], k -> new ArrayList<>()).add(curr);
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int ind : groupOrder) {
            ans.addAll(ordered.getOrDefault(ind, new ArrayList<>()));
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}