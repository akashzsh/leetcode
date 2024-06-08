class Solution {
public:
    typedef long long ll;
    
    double myPow(double x, int n) {
        bool is_neg = false;
        ll nn = n;
        
        if (n < 0) {
            is_neg = true;
            nn = -nn;
        }
        
        double res = 1;
        
        while (nn > 0) {
            if (nn & 1) {
                res = res * x;
                nn--;
            } else {
                x = x * x;
                nn >>= 1;
            }
        }
        
        return is_neg ? 1 / res : res;
    }
};