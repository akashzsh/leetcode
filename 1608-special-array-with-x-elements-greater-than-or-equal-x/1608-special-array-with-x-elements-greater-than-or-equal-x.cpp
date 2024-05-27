class Solution {
public:
    int binary_searching(int target, vector<int>& nums, int& N) {
        int low = 0, high = nums.size() - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return N - low;
    }
    
    int specialArray(vector<int>& nums) {
        int N = nums.size();
        sort(nums.begin(), nums.end());
        int low = 0, high = INT_MAX;
        
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            // cout << "MID IS " << mid << "\n";
            int gte = binary_searching(mid, nums, N);
            // cout << "GTE is " << gte << "\n";
            // if (gte == mid) {
            //     return mid;
            // }
            
            if (gte < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        int cnt = 0;
        for (int& it : nums) {
            if (it >= high) {
                cnt++;
            }
        }
        
        return cnt == high ? high : -1;
    }
};

// [21,3,5,11,16]