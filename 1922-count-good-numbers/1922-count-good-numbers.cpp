class Solution {
public:
    typedef long long ll;
    
    ll f(int x, ll n, int &M) {
        if (n == 0) {
            return 1;
        }
        
        if (n & 1) {
            return x * f(x, n - 1, M) % M;
        } else {
            return f(((ll)x * x) % M, n / 2, M) % M;
        }
    }
    
    int countGoodNumbers(long long n) {
        int M = int(1e9) + 7;
        
        ll res = 1, even = ceil(n/2.0), odd = floor(n/2.0);
        
        if (even != 0) res = f(5, even, M) % M;
        if (odd != 0) res = (res % M * f(4, odd, M) % M) % M;
        
        return res % M;
    }
};