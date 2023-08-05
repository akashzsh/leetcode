class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generate(1, n);
    }
    
    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generate(start, i - 1);
            List<TreeNode> rightTree = generate(i + 1, end);
            
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = left;
                    curr.right = right;
                    res.add(curr);
                }
            }
        }
        return res;
    }
}