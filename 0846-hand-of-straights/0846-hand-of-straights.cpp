class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        int n = hand.size();
        
        if (n % groupSize != 0) {
            return false;
        }
        
        sort(hand.begin(), hand.end());
        unordered_map<int, int> mp;
        
        for (auto& it : hand) {
            mp[it]++;
        }
        
        int groups = 0;
        
        for (auto& it : hand) {
            if (mp.find(it) == mp.end()) {
                continue;
            }
            for (int cur = it; cur < it + groupSize; cur++) {
                if (mp.find(cur) == mp.end()) {
                    return false;
                }
                mp[cur]--;
                if (mp[cur] == 0) mp.erase(cur);
            }
            groups++;
        }
        
        return groups == (n / groupSize);
    }
};