class Solution {
public:
    int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        
        bool is_neg = false;
        
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            is_neg = true;
        }
        
        long long n = abs(dividend), d = abs(divisor);
        
        long long res = 0;
        
        while (n >= d) {
            
            int cnt = 0;
            
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
            
            res += (1 << cnt);
            
            n = n - (d << cnt);
        }
        
        if (res == (1 << 31)) {
            return is_neg ? INT_MIN : INT_MAX;
        }
        
        return is_neg ? (int)(-res) : (int)(res);
    }
};