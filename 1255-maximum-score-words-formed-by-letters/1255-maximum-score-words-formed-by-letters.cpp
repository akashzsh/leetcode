class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        vector<int> fq(26);
        
        for (auto& ch : letters) {
            fq[ch - 'a']++;
        }
        
        int res = 0;
        
        for (int i = 0, n = words.size(), N = 1 << n, cur = 0; i < N; i++, cur = 0) {
            vector<int> freq(26);
            bool flag = false;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    for (int k = words[j].size() - 1; k >= 0; k--) {
                        freq[words[j][k] - 'a']++;
                        
                        if (freq[words[j][k] - 'a'] > fq[words[j][k] - 'a']) {
                            flag = true;
                            break;
                        }
                        
                        cur = cur + score[words[j][k] - 'a'];
                    }
                }
            }
            if (flag) {
                continue;
            }
            res = max(res, cur);
        }
        
        return res;
    }
};