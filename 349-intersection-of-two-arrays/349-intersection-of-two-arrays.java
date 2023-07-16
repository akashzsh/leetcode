class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i : nums1) map.put(i, true);
        for (int i : nums2) {
            if (map.get(i) != null && map.get(i) == true) {
                res.add(i);
                map.put(i, false);
            }
        }
        int len = res.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) ans[i] = res.get(i);
        return ans;
    }
}