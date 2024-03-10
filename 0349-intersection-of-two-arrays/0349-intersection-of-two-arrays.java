class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        for (int i : nums1) {
            map.put(i, true);
        }
        
        for (int i : nums2) {
            if (map.containsKey(i)) {
                res.add(i);
                map.remove(i);
            }
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}