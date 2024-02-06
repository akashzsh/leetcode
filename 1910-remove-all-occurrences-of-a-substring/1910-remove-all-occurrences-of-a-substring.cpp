class Solution {
public:
    string removeOccurrences(string s, string part) {
        int n = s.size(), m = part.size();
        string res = s;
        int j = 0;
        for (int i = 0; i < n; i++) {
            res[j] = s[i];
            j++;
            if (j >= m && res.substr(j - m, m) == part) {
                j -= m;
            }
        }
        return res.substr(0, j);
    }
};