class Solution {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, len = nums.length, res = 0;
        for (int i : nums) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        for (int i : nums) if (i > min && i < max) res++;
        return res;
    }
}