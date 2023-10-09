class Solution {
    public int differenceOfSums(int n, int m) {
        int sum = 0, divisible = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            if (i % m == 0) divisible += i;
        }
        return (sum - divisible) - divisible;
    }
}