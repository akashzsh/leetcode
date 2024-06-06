class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        int n = hand.size();
        
        if (n % groupSize != 0) {
            return false;
        }
        
        unordered_map<int, int> mp;
        sort(hand.begin(), hand.end());
        
        for (int i = 0; i < n; i++) {
            mp[hand[i]]++;
        }
        
        int group = 0;
        
        for (int i = 0; i < n; i++) {
            int cur = hand[i];
            
            if (mp.find(cur) == mp.end()) {
                continue;
            }
            
            for (int j = cur; j < cur + groupSize; j++) {
                if (mp.find(j) == mp.end()) {
                    return false;
                }
                mp[j]--;
                if (mp[j] == 0) {
                    mp.erase(j);
                }
            }
            
            group++;
        }
        
        return group == (n / groupSize);
    }
};