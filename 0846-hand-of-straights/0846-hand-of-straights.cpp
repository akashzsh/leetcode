class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        int n = hand.size();
        
        if (n % groupSize != 0) {
            return false;
        }
        
        sort(hand.begin(), hand.end());
        
        unordered_map<int, int> mp;
        
        for (int& j : hand) {
            mp[j]++;
        }
        
        int groups = 0;
        
        for (int& cur : hand) {
            if (mp.find(cur) == mp.end()) {
                continue;
            }
            
            for (int k = cur; k < cur + groupSize; k++) {
                if (mp.find(k) == mp.end()) {
                    return false;
                } else {
                    mp[k]--;
                    if (mp[k] == 0) mp.erase(k);
                }
            }
            
            groups++;
        }
        
        return groups == (n / groupSize);
    }
};