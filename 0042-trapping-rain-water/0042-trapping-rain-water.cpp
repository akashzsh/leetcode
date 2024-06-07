class Solution {
public:
    int trap(vector<int>& height) {
        int l = 0, r = height.size() - 1, lm = INT_MIN, rm = INT_MIN, res = 0;
        
        while (l <= r) {
            if (height[l] <= height[r]) {
                if (height[l] > lm) {
                    lm = height[l];
                } else {
                    res = res + (lm - height[l]);
                }
                l++;
            } else {
                if (height[r] > rm) {
                    rm = height[r];
                } else {
                    res = res + (rm - height[r]);
                }
                r--;
            }
        }
        
        return res;
    }
};