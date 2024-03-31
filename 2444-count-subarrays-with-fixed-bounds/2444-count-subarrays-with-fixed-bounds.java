class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minKPosition = -1, maxKPosition = -1, culprit = -1;
        
        long res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] < minK || nums[i] > maxK) {
                culprit = i;
            }
            
            if (nums[i] == minK) {
                minKPosition = i;
            }
            
            if (nums[i] == maxK) {
                maxKPosition = i;
            }
            
            int smaller = Math.min(minKPosition, maxKPosition);
            int temp = smaller - culprit;
            
            res += temp < 0 ? 0l : (long)(smaller - culprit);
        }
        
        return res;
    }
}