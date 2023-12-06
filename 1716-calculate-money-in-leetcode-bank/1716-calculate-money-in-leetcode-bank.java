class Solution {
    public int totalMoney(int n) {
        int sum = 0, lastMonday = 0, cnt = 1;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                lastMonday++;
                sum += lastMonday;
                cnt = lastMonday;
            } else {
                cnt++;
                sum = sum + cnt;
            }
        }
        return sum;
    }
}