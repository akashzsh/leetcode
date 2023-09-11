class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            List<Integer> tmp = map.get(groupSizes[i]);
            tmp.add(i);
            if (tmp.size() == groupSizes[i]) {
                res.add(new ArrayList<>(tmp));
                map.remove(groupSizes[i]);
            }
        }
        return res;
    }
}