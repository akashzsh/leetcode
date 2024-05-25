class Solution {
public:
    string f(int c1, int c2, string& s, int& n) {
        while (c1 >= 0 && c2 < n && s[c1] == s[c2]) {
            c1--;
            c2++;
        }
        return s.substr(c1 + 1, c2 - c1 - 1);
    }
    
    string longestPalindrome(string s) {
        if (s.size() <= 1) {
            return s;
        }
        
        string res = "";
        
        for (int i = 0, n = s.size(); i < n - 1; i++) {
            string s1 = f(i, i, s, n);
            if (s1.size() > res.size()) {
                res = s1;
            }
            s1 = f(i, i + 1, s, n);
            if (s1.size() > res.size()) {
                res = s1;
            }
        }
        
        return res;
    }
};