class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int curMax = 0, res = 0, el = -1;
        
        for (int left = 0, right = 0; right < nums.length; right++) {
            
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            if (map.get(nums[right]) > curMax) {
                curMax = map.get(nums[right]);
                el = nums[right];
            }
            
            while (curMax > k) {
                if (nums[left] == el) {
                    curMax--;
                }
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                left++;
            }
            
            res = Math.max(res, right - left + 1);
        }
        
        return res;
    }
}