class Solution {
    
    public void helper(TreeNode root, List<Integer> result) {
        if (root != null) {
            helper(root.left, result);
            helper(root.right, result);
            result.add(root.val);
        }
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
}