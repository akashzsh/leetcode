class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        int n = words.size();
        vector<vector<int>> bucket(n, vector<int>(26, 0));
        
        for (int i = 0; i < n; i++) {
            for (auto& ch : words[i]) {
                bucket[i][ch - 'a']++;
            }
        }
        
        vector<string> res;
        
        for (int i = 0; i < 26; i++) {
            int mini = INT_MAX;
            for (int j = 0; j < n; j++) {
                mini = min(mini, bucket[j][i]);
            }
            if (mini != 0) {
                string str = "a";
                str[0] = str[0] + i;
                while (mini > 0) {
                    res.push_back(str);
                    mini--;
                }
            }
        }
        
        return res;
    }
};