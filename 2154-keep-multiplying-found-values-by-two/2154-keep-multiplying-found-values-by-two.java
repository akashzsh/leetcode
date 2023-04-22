class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> seen = new HashSet<>();
        int i = 0;
        while (true) {
            if (i < nums.length) seen.add(nums[i++]);
            if (seen.contains(original)) original *= 2;
            if (i == nums.length && !seen.contains(original)) return original;
        }
    }
}