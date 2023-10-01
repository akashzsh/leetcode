class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0, maxab = 0, maxa = 0;
        for (int i : nums) {
            res = Math.max(res, 1L * maxab * i);
            maxab = Math.max(maxab, maxa - i);
            maxa = Math.max(maxa, i);
        }
        return res;
    }
}