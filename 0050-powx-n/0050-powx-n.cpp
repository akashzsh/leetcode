class Solution {
public:
    typedef long long ll;
    
    double myPow(double x, int n) {
        int sign = 1;
        ll m = ll(n);
        
        if (n < 0) {
            sign = -1;
            m = m * -1;
        }
        
        double res = 1;
        
        while (m > 0) {
            if (m & 1) {
                res = res * x;
                m = m - 1;
            } else {
                x = x * x;
                m = m / 2;
            }
        }
        
        return sign == 1 ? res : 1 / res;
    }
};