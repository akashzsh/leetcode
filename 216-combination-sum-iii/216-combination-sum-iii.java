class Solution {
    public void combinations(int index, int length, int target, List<Integer> ds, List<List<Integer>> res) {
        if (ds.size() == length && target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i <= 9; i++) {
            ds.add(i);
            combinations(i + 1, length, target - i, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(1, k, n, new ArrayList<>(), res);
        return res;
    }
}