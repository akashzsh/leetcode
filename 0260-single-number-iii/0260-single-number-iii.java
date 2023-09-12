class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) xor ^= i;
        xor &= -xor;
        int[] ans = {0, 0};
        for (int i : nums) {
            if ((i & xor) == 0) ans[0] ^= i;
            else ans[1] ^= i;
        }
        return ans;
    }
}