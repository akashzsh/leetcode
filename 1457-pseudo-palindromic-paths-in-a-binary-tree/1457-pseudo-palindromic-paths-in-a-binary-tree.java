class Solution {
    public int solve(TreeNode root, int count) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        count = count ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            if ((count & (count - 1)) == 0) {
                result++;
            }
        }
        result += solve(root.left, count);
        result += solve(root.right, count);
        
        return result;
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        return solve(root, 0);
    }
}