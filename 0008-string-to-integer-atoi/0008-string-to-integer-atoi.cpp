class Solution {
public:
    int myAtoi(string s) {
        int res = 0, i = 0, n = s.size();
        bool is_neg = false;
        
        while (i < n && s[i] == ' ') {
            i++;
        }
        
        if (i < n && s[i] == '-' || s[i] == '+') {
            if (s[i] == '-') {
                is_neg = true;
            }
            i++;
        }
        
        while (i < n) {
            if (s[i] >= '0' && s[i] <= '9') {
                if ((res > INT_MAX / 10) || (res == INT_MAX / 10 && s[i] - '0' > 7)) {
                    return is_neg ? INT_MIN : INT_MAX;
                }
                res = res * 10 + (s[i] - '0');
            } else {
                break;
            }
            i++;
        }
        
        return is_neg ? -res : res;
    }
};