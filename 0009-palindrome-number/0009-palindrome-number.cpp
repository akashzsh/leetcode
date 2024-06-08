class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        long long rev = 0, xx = x;
        
        while (x != 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        
        return rev == xx;
    }
};