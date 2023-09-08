class Solution {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    public int subarrayLCM(int[] nums, int k) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i, cur = 1; j < n && k % nums[j] == 0; j++) {
                cur = lcm(cur, nums[j]);
                cnt += (cur == k) ? 1 : 0;            
            }
        }
        return cnt;
    }
}