class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0, currSum = 0;
        for (int i : nums) sum += i;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            currSum += nums[i];
            res.add(nums[i]);
            if (currSum > sum - currSum) return res;
        }
        return new ArrayList<Integer>();
    }
}