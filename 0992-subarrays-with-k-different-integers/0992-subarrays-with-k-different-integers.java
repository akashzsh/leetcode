class Solution {
    public int countAtMostK(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int cnt = 0, left = 0, right = 0;
        
        while (right < nums.length) {
            
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            while (map.size() > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);

                if (map.get(nums[left]) <= 0) {
                    map.remove(nums[left]);
                }

                left++;
            }
            
            cnt = cnt + (right - left + 1);
            
            right++;
        }
        
        return cnt;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {       
        return countAtMostK(nums, k) - countAtMostK(nums, k - 1);
    }
}