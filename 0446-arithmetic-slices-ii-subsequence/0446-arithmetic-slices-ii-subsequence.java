class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, res = 0;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        
        for (int i = 0; i < n; ++i) dp[i] = new HashMap<>();
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                int c1 = dp[i].getOrDefault(diff, 0);
                int c2 = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, c1 + c2 + 1);
                res += c2;
            }
        }
        return res;
    }
}