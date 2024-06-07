class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> res(nums.size() - k + 1);
        deque<int> q;
        
        for (int i = 0, n = nums.size(); i < n; i++) {
            while (!q.empty() && q.front() < i - k + 1) {
                q.pop_front();
            }
            while (!q.empty() && nums[q.back()] < nums[i]) {
                q.pop_back();
            }
            q.push_back(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.front()];
            }
        }
        
        return res;
    }
};