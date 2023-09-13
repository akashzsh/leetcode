class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0] + "";
        if (n == 2) return nums[0] + "/" + nums[1];
        StringBuilder res = new StringBuilder(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < n; i++) res.append("/" + nums[i]);
        res.append(")");
        return res.toString();
    }
}