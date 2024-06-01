class Solution {
public:
    int countPrimes(int n) {
        if (n == 0) {
            return 0;
        }
        
        vector<bool> is_prime(n, true);
        
        is_prime[0] = is_prime[1] = false;
        int cnt = 0;
        
        for (int i = 2; i < n; i++) {
            if (is_prime[i]) {
                cnt++;
                if ((long long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        is_prime[j] = false;
                    }
                }
            }
        }
        
        return cnt;
    }
};