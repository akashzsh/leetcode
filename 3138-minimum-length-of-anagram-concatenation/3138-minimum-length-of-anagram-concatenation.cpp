class Solution {
public:
    bool is_valid(string& s, int& len, int& N) {
        int freq[26] = {0};
        
        for (int i = 0; i < len; i++) {
            freq[s[i] - 'a']++;
        }
        
        for (int i = len; i < N; i += len) {
            int fq[26] = {0};
            for (int j = i; j < i + len; j++) {
                fq[s[j] - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (freq[i] != fq[i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    int minAnagramLength(string s) {
        int N = s.size();
        
        for (int i = 1; i <= N; i++) {
            if (N % i == 0 && is_valid(s, i, N)) {
                return i;
            }
        }
        
        return N;
    }
};