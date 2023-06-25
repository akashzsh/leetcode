class Solution {
    
    public void combinations(int index, int target, int[] nums, List<Integer> ds, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;
            ds.add(nums[i]);
            combinations(i + 1, target - nums[i], nums, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(0, target, candidates, new ArrayList<>(), result);
        return result;
    }
}