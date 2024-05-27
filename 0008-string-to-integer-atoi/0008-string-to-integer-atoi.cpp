class Solution {
public:
    int f(int i, string& s, int res, int& N, int& sign) {
        if (i == N) {
            return sign * res;
        }
        
        if (s[i] < '0' || s[i] > '9') {
            return sign * res;
        }
        
        if ((res > INT_MAX / 10) || (res == INT_MAX / 10 && s[i] > '7')) {
            return sign == 1 ? INT_MAX : INT_MIN;
        }
        
        return f(i + 1, s, res * 10 + (s[i] - '0'), N, sign);
    }
    
    int myAtoi(string s) {
        int sign = 1;
        
        int i = 0, N = s.size();
        
        while (i < N && s[i] == ' ') {
            i++;
        }
        
        if (s[i] == '-') {
            sign = -1;
            i++;
        } else if (s[i] == '+') {
            i++;
        }
        
        return f(i, s, 0, N, sign);
    }
};