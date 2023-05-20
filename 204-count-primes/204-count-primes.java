class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        int[] notPrime = new int[n];
        notPrime[0] = notPrime[1] = 1;
        int count = 0;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (notPrime[i] == 0) {
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = 1;
                }
            }
        }
        for (int i : notPrime) if (i == 0) count++;
        return count;
    }
}