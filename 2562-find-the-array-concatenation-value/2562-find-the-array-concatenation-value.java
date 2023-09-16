class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        long sum = 0;
        while (i < j) {
            String cur = (nums[i] + "") + (nums[j] + "");
            sum += Integer.parseInt(cur);
            i++;
            j--;
        }
        if (i == j) sum += nums[i];
        return sum;
    }
}