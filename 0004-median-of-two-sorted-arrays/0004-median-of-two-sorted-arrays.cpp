class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size(), m = nums2.size();
        
        if (m < n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int left_el = (n + m + 1) >> 1;
        
        int low = 0, high = n;
        
        while (low <= high) {
            int mid1 = low + ((high - low) >> 1);
            int lu = INT_MIN, ld = INT_MIN, ru = INT_MAX, rd = INT_MAX;
            
            int mid2 = left_el - mid1;
            if (mid1 < n) {
                ru = nums1[mid1];
            }
            
            if (mid2 < m) {
                rd = nums2[mid2];
            }
            
            if (mid1 - 1 >= 0) {
                lu = nums1[mid1 - 1];
            }
            
            if (mid2 - 1 >= 0) {
                ld = nums2[mid2 - 1];
            }
            
            if (lu <= rd && ld <= ru) {
                if ((m + n) & 1) {
                    return double(max(lu, ld));
                } else {
                    return double(max(lu, ld) + min(ru, rd)) / 2.0;
                }
            }
            
            if (ru < ld) {
                low = mid1 + 1;
            } else if (lu > rd) {
                high = mid1 - 1;
            }
        }
        
        return -1;
    }
};