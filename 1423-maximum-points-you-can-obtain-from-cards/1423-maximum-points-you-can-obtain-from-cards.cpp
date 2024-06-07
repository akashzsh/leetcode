class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int ls = 0, rs = 0, res = 0;
        
        for (int i = 0; i < k; i++) {
            ls += cardPoints[i];
        }
        
        res = ls;
        
        for (int i = 0, n = cardPoints.size(); i < k; i++) {
            ls -= cardPoints[k - i - 1];
            rs += cardPoints[n - i - 1];
            
            res = max(res, ls + rs);
        }
        
        return res;
    }
};