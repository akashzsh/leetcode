class Solution {
    public long minimumPossibleSum(int n, int target) {
        long ans = 0;
        HashSet<Long> set = new HashSet<>();
        for (long i = 1; set.size() < n; i++) {
            if (!set.contains(target - i)) {
                set.add(i);
                ans += i;
            }
        }
        return ans;
    }
}