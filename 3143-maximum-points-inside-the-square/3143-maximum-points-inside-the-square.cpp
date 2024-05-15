class Solution {
public:
    bool is_possible(int len, vector<vector<int>>& points, string& s, int& res, int& N) {
        unordered_set<char> set;
        // cout << "CALL " << len << "\n";
        int right_up = len / 2, left_down = -len / 2;
        
        for (int i = 0; i < N; i++) {
            if (points[i][0] <= right_up && points[i][0] >= left_down && points[i][1] <= right_up && points[i][1] >= left_down) {
                if (set.find(s[i]) != set.end()) {
                    return false;
                }
                set.insert(s[i]);
            }
        }
        
        // for (auto it : set) cout << it << " ";
        // cout << "\n";
        
        res = set.size();
        return true;
    }
    
    int maxPointsInsideSquare(vector<vector<int>>& points, string s) {
        int low = 0, high = INT_MAX, ans = 0, res = 0, n = s.size();
        
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            res = 0;
            if (is_possible(mid, points, s, res, n)) {
                low = mid + 1;
                
                if (res == n) {
                    return res;
                }
                
                ans = max(ans, res);
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
};