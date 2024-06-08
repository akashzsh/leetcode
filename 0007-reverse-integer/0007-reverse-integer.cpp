class Solution {
public:
    int reverse(int x) {
        bool is_neg = false;
        
        if (x == INT_MIN) {
            return 0;
        }
        
        if (x < 0) {
            is_neg = true;
            x = -x;
        }
        
        int res = 0;
        
        while (x > 0) {
            int digit = x % 10;
            
            if (res > INT_MAX / 10 || res == INT_MAX / 10 && digit > 7) {
                return 0;
            }
            
            res = res * 10 + digit;
            x /= 10;
        }
        
        return is_neg ? -res : res;
    }
};