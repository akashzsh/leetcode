class Solution {
    public int minOperations(int n) {
        if ((n & 1) == 1) {
            return ((n - 1) / 2) * ((n - 1) / 2 + 1);
        } else {
            return (n / 2) * (n / 2);
        }
    }
}