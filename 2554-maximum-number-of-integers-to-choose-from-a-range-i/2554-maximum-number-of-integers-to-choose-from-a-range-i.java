class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int cnt = 0, curSum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int cur : banned) set.add(cur);
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i) && curSum + i <= maxSum) {
                curSum += i;
                cnt++;
            }
        }
        return cnt;
    }
}