class Solution {
public:
    void LPS(string& s, vector<int>& lps, int& N) {
        int i = 1, idx = 0;
        
        while (i < N) {
            if (s[i] == s[idx]) {
                lps[i] = idx + 1;
                i++;
                idx++;
            } else {
                if (idx != 0) {
                    idx = lps[idx - 1];
                } else {
                    i++;
                }
            }
        }
    }
    
    bool kmp(string& s, string& p) {
        int S = s.size(), P = p.size();
        
        vector<int> lps(P);
        
        LPS(p, lps, P);
        
        int i = 0, j = 0;
        
        while (i < S) {
            if (s[i] == p[j]) {
                i++;
                j++;
            } else {
                if (j == P) {
                    return true;
                }
                
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        if (j == P) {
            return true;
        }
        
        return false;
    }
    
    bool rotateString(string s, string goal) {
        if (s.size() > goal.size()) {
            return false;
        }
        
        s = s + s;
        return kmp(s, goal);
    }
};