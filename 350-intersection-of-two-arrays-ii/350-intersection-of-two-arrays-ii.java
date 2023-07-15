class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i : nums2) {
            if (map.get(i) != null && map.get(i) > 0) {
                res.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int len = res.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}