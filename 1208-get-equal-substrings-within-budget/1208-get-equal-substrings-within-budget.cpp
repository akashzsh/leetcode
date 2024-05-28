class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int res = 0;
        
        for (int left = 0, right = 0, N = s.size(), cost = 0; right < N; right++) {
            cost = cost + abs(s[right] - t[right]);
            
            while (cost > maxCost) {
                cost = cost - abs(s[left] - t[left]);
                left++;
            }
            
            res = max(res, right - left + 1);
        }
        
        return res;
    }
};