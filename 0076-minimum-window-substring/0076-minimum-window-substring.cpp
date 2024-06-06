class Solution {
public:
    string minWindow(string s, string t) {
        int S = s.size(), T = t.size();
        
        if (T > S) {
            return "";
        }
        
        vector<int> ht(123);
        
        for (auto& it : t) {
            ht[it]++;
        }
        
        int start = -1, min_len = INT_MAX;
        
        for (int l = 0, r = 0, cnt = 0; r < S; r++) {
            if (ht[s[r]] > 0) {
                cnt++;
            }
            ht[s[r]]--;
            
            while (cnt == T) {
                int cur_window = r - l + 1;
                if (cur_window < min_len) {
                    start = l;
                    min_len = cur_window;
                }
                ht[s[l]]++;
                if (ht[s[l]] > 0) {
                    cnt--;
                }
                l++;
            }
        }
        
        return start == -1 ? "" : s.substr(start, min_len);
    }
};