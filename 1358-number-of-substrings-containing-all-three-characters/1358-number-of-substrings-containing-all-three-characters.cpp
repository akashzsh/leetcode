class Solution {
public:
    int numberOfSubstrings(string s) {
        vector<int> ls(3, -1);
        
        int cnt = 0;
        
        for (int i = 0, n = s.size(); i < n; i++) {
            ls[s[i] - 'a'] = i;
            
            if (ls[0] != -1 and ls[1] != -1 and ls[2] != -1) {
                cnt += 1 + *min_element(ls.begin(), ls.end());
            }
        }
        
        return cnt;
    }
};