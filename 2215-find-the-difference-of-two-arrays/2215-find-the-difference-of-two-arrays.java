class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        for (int i : nums1) setA.add(i);
        for (int i : nums2) setB.add(i);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (int i : setA) if (!setB.contains(i)) result.get(0).add(i);
        for (int i : setB) if (!setA.contains(i)) result.get(1).add(i);
        return result;
    }
}