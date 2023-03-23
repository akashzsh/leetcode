class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int length = nums.length;
        int totalSum = 0;
        int currentSum = 0;
        int[] resultArray = new int[length];
        for (int i : nums) totalSum += i;
        for (int i = 0; i < length; i++) {
            currentSum += nums[i];
            if (i == 0) resultArray[i] = Math.abs(currentSum - totalSum);
            else if (i == length - 1) resultArray[i] = Math.abs(currentSum - nums[i]);            
            else resultArray[i] = Math.abs((currentSum - nums[i])-(totalSum - currentSum));
        }
        return resultArray;
    }
}
