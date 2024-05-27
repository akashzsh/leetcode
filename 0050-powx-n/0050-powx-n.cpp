class Solution {
public:
    typedef long long ll;
    
    double f(double x, ll n) {
        if (n == 0) {
            return 1;
        }
        
        if (n & 1) {
            return x * f(x, n - 1);
        } else {
            return f(x * x, n / 2);
        }
    }
    
    double myPow(double x, int n) {
        int sign = 1;
        ll m = ll(n);
        
        if (n < 0) {
            sign = -1;
            m = m * -1;
        }
        
        if (sign == 1) {
            return f(x, m);
        } else {
            return 1 / f(x, m);
        }
    }
};