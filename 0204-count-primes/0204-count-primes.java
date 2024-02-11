// Sieve of Eratosthenes

class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        int cur = (int)Math.sqrt(n);
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i <= cur; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        cur = 0;
        for (int i = 0; i < n; i++) {
            if (!notPrime[i]) {
                cur++;
            }
        }
        return cur;
    }
}