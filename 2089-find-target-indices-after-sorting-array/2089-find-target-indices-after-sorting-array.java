class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0, bigger = 0;
        for (int i : nums) {
            if (i < target) smaller++;
            else if (i > target) bigger++;
        }
        int len = nums.length - bigger;
        List<Integer> res = new ArrayList<>();
        for (int i = smaller; i < len; i++) res.add(i);
        return res;
    }
}