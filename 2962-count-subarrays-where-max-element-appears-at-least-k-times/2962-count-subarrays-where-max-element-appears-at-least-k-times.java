class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxi = -1;
        
        for (int cur : nums) {
            if (cur > maxi) {
                maxi = cur;
            }
        }
        
        int freq = 0;
        long res = 0l;
        
        for (int left = 0, right = 0; right < nums.length; right++) {
            
            if (nums[right] == maxi) {
                freq++;
            }
            
            while (freq >= k) {
                
                if (nums[left] == maxi) {
                    freq--;
                }
                
                left++;
            }
            
            res += left;
        }
        
        return res;
    }
}