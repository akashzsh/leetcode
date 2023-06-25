class Solution {
    
    public void combinations(int index, int target, int[] nums, List<Integer> ds, List<List<Integer>> result) {
        if (index == nums.length) {
            if (target == 0) result.add(new ArrayList(ds));
            return;
        }
        if (nums[index] <= target) {
            ds.add(nums[index]);
            combinations(index, target - nums[index], nums, ds, result);
            ds.remove(ds.size() - 1);
        }
        combinations(index + 1, target, nums, ds, result);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(0, target, candidates, new ArrayList<>(), result);
        return result;
    }
}