class Solution {
    public void f(int i, List<List<Integer>> res, List<Integer> ds, int k, int target) {
        if (i == 9) {
            if (target == 0 && ds.size() == k) {
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if ((i + 1) <= target) {
            ds.add(i + 1);
            f(i + 1, res, ds, k, target - (i + 1));
            ds.remove(ds.size() - 1);
        }
        f(i + 1, res, ds, k, target);
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        
        f(0, res, new ArrayList<>(), k, n);
        
        return res;
    }
}