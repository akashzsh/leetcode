class Solution {
    private HashMap<Integer, List<TreeNode>> dp = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        
        if (n == 1) {
            return Arrays.asList(new TreeNode());
        }
        
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode cur = new TreeNode(0, l, r);
                    res.add(cur);
                }
            }
        }
        dp.put(n, res);
        return res;
    }
}