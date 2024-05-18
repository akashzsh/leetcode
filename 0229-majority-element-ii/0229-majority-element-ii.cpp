class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int e1 = -1, e2 = -1, c1 = 0, c2 = 0, n = nums.size();
        
        for (auto& it : nums) {
            if (c1 == 0 && e2 != it) {
                c1 = 1;
                e1 = it;
            } else if (c2 == 0 && e1 != it) {
                c2 = 1;
                e2 = it;
            } else if (e1 == it) {
                c1++;
            } else if (e2 == it) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        
        vector<int> res;
        
        // reuse
        c1 = 0;
        c2 = 0;
        
        for (auto& it : nums) {
            if (it == e1) {
                c1++;
            } else if (it == e2) {
                c2++;
            }
        }
        
        if (c1 > n / 3) {
            res.push_back(e1);
        }
        
        if (c2 > n / 3) {
            res.push_back(e2);
        }
        
        return res;
    }
};