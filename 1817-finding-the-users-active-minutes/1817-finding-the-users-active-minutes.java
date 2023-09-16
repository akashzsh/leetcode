class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0], time = log[1];
            if (!map.containsKey(id)) map.put(id, new HashSet<>());
            map.get(id).add(time);
        }
        int[] res = new int[k];
        for (int id : map.keySet()) {
            int size = map.get(id).size();
            res[size - 1]++;
        }
        return res;
    }
}