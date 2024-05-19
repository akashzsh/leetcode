class Solution {
   public:
    void merge(vector<int>& nums, int low, int mid, int high) {
        vector<int> vec(high - low + 1);
        int i = low, j = mid + 1, cnt = 0, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                vec[k++] = nums[i++];
            } else {
                vec[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            vec[k++] = nums[i++];
        }

        while (j <= high) {
            vec[k++] = nums[j++];
        }

        for (int k = low; k <= high; k++) {
            nums[k] = vec[k - low];
        }
    }

    int f(vector<int>& nums, int low, int mid, int high) {
        int cnt = 0;
        for (int i = low, j = mid + 1; i <= mid; i++) {
            while (j <= high && nums[i] > 2.0 * nums[j]) {
                j++;
            }
            cnt = cnt + (j - (mid + 1));
        }

        return cnt;
    }

    int mergeSort(vector<int>& nums, int low, int high) {
        int cnt = 0;
        if (low < high) {
            int mid = low + ((high - low) >> 1);
            cnt += mergeSort(nums, low, mid);
            cnt += mergeSort(nums, mid + 1, high);
            cnt += f(nums, low, mid, high);
            merge(nums, low, mid, high);
        }
        return cnt;
    }

    int reversePairs(vector<int>& nums) {
        return mergeSort(nums, 0, nums.size() - 1);
    }
};