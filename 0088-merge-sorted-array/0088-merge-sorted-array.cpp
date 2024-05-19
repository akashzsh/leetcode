class Solution {
   public:
    void swapIfGreater(vector<int>& nums1, vector<int>& nums2, int p1, int p2) {
        if (nums1[p1] > nums2[p2]) {
            swap(nums1[p1], nums2[p2]);
        }
    }

    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int t = m + n;
        
        if (n == 0) {
            return;
        }
        
        int gap = (t / 2) + (t % 2);

        while (gap > 0) {
            int left = 0, right = left + gap;

            while (right < t) {
                if (left < m && right < m) {
                    swapIfGreater(nums1, nums1, left, right);
                } else if (left < m && right >= m) {
                    swapIfGreater(nums1, nums2, left, right - m);
                } else {
                    swapIfGreater(nums2, nums2, left - m, right - m);
                }

                left++;
                right++;
            }

            if (gap == 1) {
                break;
            }

            gap = (gap / 2) + (gap % 2);
        }

        for (int j = m; j < t; j++) {
            nums1[j] = nums2[j - m];
        }
    }
};