class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1, lastIndex = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int p = 0; p < i; p++) {
                if (nums[i] % nums[p] == 0 && dp[i] < 1 + dp[p]) {
                    hash[i] = p;
                    dp[i] = 1 + dp[p];
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            res.add(nums[lastIndex]);
        }
        Collections.reverse(res);
        return res;
    }
}