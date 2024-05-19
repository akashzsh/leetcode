class Solution {
   public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;

        sort(intervals.begin(), intervals.end());

        for (int i = 0, n = intervals.size(); i < n; i++) {
            if (i == 0 || res.back()[1] < intervals[i][0]) {
                res.push_back({intervals[i][0], intervals[i][1]});
            } else {
                res.back()[1] = max(res.back()[1], intervals[i][1]);
            }
        }

        return res;
    }
};