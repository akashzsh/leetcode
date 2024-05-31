class Solution {
public:
    typedef long long ll;
    
    int divide(int dividend, int divisor) {
        int sign = 1;
        
        if ((dividend >= 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        
        ll num = abs(ll(dividend));
        ll den = abs(ll(divisor));
        // cout << "num is " << num << " and den is " << den << "\n";
        ll res = 0;
        
        while (num >= den) {
            int power = 0;
            while (num >= (den << power)) {
                power++;
            }
            power--;
            num = num - (den << power);
            res = res + (1 << power);
        }
        
        if (res == (1 << 31)) {
            return sign == 1 ? INT_MAX : INT_MIN;
        }
        
        return sign * res;
    }
};