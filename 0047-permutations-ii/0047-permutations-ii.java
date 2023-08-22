class Solution {
    private void f(int[] nums, ArrayList<Integer> ds, List<List<Integer>> res, int n, boolean[] used) {
        if (ds.size() == n) {
            res.add(new ArrayList<Integer>(ds));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            ds.add(nums[i]);
            f(nums, ds, res, n, used);
            used[i] = false;
            ds.remove(ds.size() - 1);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, new ArrayList<>(), res, n, used);
        return res;
    }
}