class Solution {
    public int getSum(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n % 10);
            n /= 10;
        }
        return ans;
    }
    
    public int countBalls(int lowLimit, int highLimit) {
        int[] cnt = new int[46];
        int ans = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = getSum(i);
            cnt[sum]++;
            if (cnt[sum] >= ans) ans = cnt[sum];
        }
        return ans;
    }
}