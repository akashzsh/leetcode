class Solution {
    public void f(int i, int[] nums, List<List<Integer>> res, List<Integer> ds, int k) {
        if (i >= nums.length) {
            if (ds.size() == k) res.add(new ArrayList<>(ds));
            return;
        }
        
        ds.add(nums[i]);
        f(i + 1, nums, res, ds, k);
        ds.remove(ds.size() - 1);
        f(i + 1, nums, res, ds, k);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        f(0, nums, res, new ArrayList<>(), k);
        
        return res;
    }
}