class Solution {
    public int[] buildArray(int[] nums) {
        int length = nums.length;
        if (length == 0) return new int[0];
        int[] resultArray = new int[length];
        
        for (int i : nums) {
            resultArray[i] = nums[nums[i]];
        }
        
        return resultArray;
    }
}