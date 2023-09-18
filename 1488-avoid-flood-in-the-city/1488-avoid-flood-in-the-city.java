class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length, idx = 0;
        int[] ans = new int[n];
        HashMap<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> dry = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dry.add(i);
                ans[idx++] = 1;
            } else {
                if (full.containsKey(rains[i])) {
                    Integer day = dry.higher(full.get(rains[i]));
                    if (day == null) return new int[]{};
                    ans[day] = rains[i];
                    dry.remove(day);
                }
                full.put(rains[i], i);
                ans[idx++] = -1;
            }
        }
        return ans;
    }
}