class Solution {
    private boolean check(List<Integer> nums) {
        Collections.sort(nums);
        int diff = nums.get(1) - nums.get(0);
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i + 1) - nums.get(i) != diff) return false;
        }
        return true;
    }
    
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++) tmp.add(nums[j]);
            if (check(tmp)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}