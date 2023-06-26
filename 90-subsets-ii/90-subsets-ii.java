class Solution {
    public void subsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> res) {
        res.add(new ArrayList<>(ds));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            subsets(i + 1, nums, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), res);
        return res;
    }
}