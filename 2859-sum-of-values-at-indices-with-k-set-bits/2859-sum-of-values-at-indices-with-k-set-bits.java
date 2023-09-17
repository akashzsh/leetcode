class Solution {
    private int getSetBits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        return cnt;
    }
    
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size(), sum = 0;
        for (int i = 0; i < n; i++) {
            if (getSetBits(i) == k) sum += nums.get(i);
        }
        return sum;
    }
}