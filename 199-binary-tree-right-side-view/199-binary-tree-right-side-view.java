class Solution {
    public void rightView(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (level == res.size()) res.add(root.val);
        rightView(root.right, level + 1, res);
        rightView(root.left, level + 1, res);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightView(root, 0, res);
        return res;
    }
}