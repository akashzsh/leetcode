class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> sset(nums.begin(), nums.end());
        
        int current = 0, cur_streak = 0, max_streak = 0;
        
        for (auto& it : sset) {
            if (sset.find(it - 1) != sset.end()) {
                continue;
            }
            
            current = it;
            cur_streak = 1;
            while (sset.find(current + 1) != sset.end()) {
                current++;
                cur_streak++;
            }
            max_streak = max(max_streak, cur_streak);
        }
        
        return max_streak;
    }
};