class Solution {
    
    public void combinations(int index, int length, int[] nums, List<Integer> ds, List<List<Integer>> res) {
        if (index == nums.length) {
            if (ds.size() == length) res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        combinations(index + 1, length, nums, ds, res);
        ds.remove(ds.size() - 1);
        combinations(index + 1, length, nums, ds, res);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;
        List<List<Integer>> res = new ArrayList<>();
        combinations(0, k, nums, new ArrayList<>(), res);
        return res;
    }
}