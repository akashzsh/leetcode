class Solution {
    public void generate(int idx, int target, int[] nums, ArrayList<Integer> vec, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(vec));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            vec.add(nums[i]);
            generate(i + 1, target - nums[i], nums, vec, res);
            vec.remove(vec.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        generate(0, target, candidates, new ArrayList<>(), res);
        return res;
    }
}