class Solution {
public:
    double myPow(double x, int n) {
        bool is_positive = true;
        double res = 1;
        
        long long N = n;
        
        if (n < 0) {
            is_positive = false;
            N = -N;
        }
        
        while (N > 0) {
            if (N & 1) {
                res = res * x;
                N--;
            } else {
                x = x * x;
                N >>= 1;
            }
        }
        
        if (is_positive) {
            return res;
        } else {
            return 1 / res;
        }
    }
};