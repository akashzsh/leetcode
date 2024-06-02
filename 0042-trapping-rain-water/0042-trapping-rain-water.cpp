// not optimal-- but for practising prefix sum

class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int> rg(n), lg(n);
        
        lg[0] = height[0];
        for (int i = 1; i < n; i++) {
            lg[i] = max(height[i], lg[i - 1]);
        }
        
        rg[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rg[i] = max(height[i], rg[i + 1]);
        }
        
        int water = 0;
        
        // for (const auto& it : rg) cout << it << " ";
        // cout << "\n";
        // for (const auto& it : lg) cout << it << " ";
        // cout << "\n";
        
        for (int i = 0; i < n; i++) {
            if (rg[i] == 0 || lg[i] == 0) {
                continue;
            }
            // cout << "adding " << min(rg[i], lg[i]) - height[i] << "\n";
            water += min(rg[i], lg[i]) - height[i];
        }
        
        return water;
    }
};