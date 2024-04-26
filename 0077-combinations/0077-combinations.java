class Solution {
    public void f(int i, List<List<Integer>> res, List<Integer> ds, int k, int n) {
        if (ds.size() == k) {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        if (i == n) {
            return;
        }
        
        ds.add(i + 1);
        f(i + 1, res, ds, k, n);
        ds.remove(ds.size() - 1);
        f(i + 1, res, ds, k, n);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        f(0, res, new ArrayList<>(), k, n);       
        return res;
    }
}