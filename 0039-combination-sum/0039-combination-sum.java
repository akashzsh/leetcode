class Solution {
    public void generate(int idx, int[] nums, int target, ArrayList<Integer> vec, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(vec));
            return;
        }
        if (idx == nums.length) {
            return;
        }
        
        vec.add(nums[idx]);
        generate(idx, nums, target - nums[idx], vec, res);
        vec.remove(vec.size() - 1);
        generate(idx + 1, nums, target, vec, res);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        generate(0, candidates, target, new ArrayList<>(), res);
        return res;
    }
}