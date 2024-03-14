class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i = 0, j = 0, sum = 0, res = 0, pZero = 0;
        
        while (j < nums.length) {
            
            sum += nums[j];
            
            while (i < j && (nums[i] == 0 || sum > goal)) {
                if (nums[i] == 0) {
                    pZero++;
                } else {
                    pZero = 0;
                }
                
                sum -= nums[i];
                i++;
            }
            
            if (sum == goal) {
                res++;
                res += pZero;
            }
            
            j++;
        }
        
        return res;
    }
}