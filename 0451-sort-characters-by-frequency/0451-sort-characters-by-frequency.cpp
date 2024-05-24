class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> mp;
        
        for (char& ch : s) {
            mp[ch]++;
        }
        
        vector<vector<char>> buckets(s.size() + 1);
        
        for (auto& it : mp) {
            buckets[it.second].push_back(it.first);
        }
        
        string res;
        for (int j = s.size(); j >= 1; j--) {
            for (auto& cur : buckets[j]) {
                res.append(j, cur);
            }
        }
        
        return res;
    }
};