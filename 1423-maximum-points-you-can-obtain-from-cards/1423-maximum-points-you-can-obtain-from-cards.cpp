class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int ls = 0;
        
        for (int i = 0; i < k; i++) {
            ls += cardPoints[i];
        }
        
        int res = ls;
        
        for (int j = 0, n = cardPoints.size(), rs = 0; j < k; j++) {
            ls -= cardPoints[k - j - 1];
            rs += cardPoints[n - j - 1];
            
            res = max(res, ls + rs);
        }
        
        return res;
    }
};