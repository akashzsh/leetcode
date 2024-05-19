class Solution {
   public:
    typedef long long ll;

    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> res;

        sort(nums.begin(), nums.end());

        for (int i = 0, n = nums.size(); i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1, p = n - 1;

                while (k < p) {
                    ll sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[p];

                    if (sum == (ll)target) {
                        res.push_back({nums[i], nums[j], nums[k], nums[p]});
                        k++;
                        p--;

                        while (k < p && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while (k < p && nums[p] == nums[p + 1]) {
                            p--;
                        }
                    } else if (sum > target) {
                        p--;
                    } else {
                        k++;
                    }
                }
            }
        }

        return res;
    }
};