class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void f(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            ArrayList<Integer> vec = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                vec.add(nums[i]);
            }
            res.add(new ArrayList<>(vec));
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            f(nums, idx + 1, res);
            swap(nums, i, idx);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums, 0, res);
        return res;
    }
}