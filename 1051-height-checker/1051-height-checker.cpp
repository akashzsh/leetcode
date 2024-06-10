class Solution {
public:
    int heightChecker(vector<int>& heights) {
        int n = heights.size();
        int maxx = heights[0];
        
        for (int i = 1; i < n; i++) {
            maxx = max(maxx, heights[i]);
        }
        
        vector<int> fq(maxx + 1);
        
        for (int& j : heights) {
            fq[j]++;
        }
        
        for (int i = 1; i <= maxx; i++) {
            fq[i] += fq[i - 1];
        }
        
        vector<int> res(n);
        for (int i = n - 1; i >= 0; i--) {
            res[--fq[heights[i]]] = heights[i];
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != res[i]) {
                cnt++;
            }
        }
        
        return cnt;
    }
};