class Solution {
    TreeNode target, ans;
    
    public void solve(TreeNode o, TreeNode c) {
        if (o == null) return;
        solve(o.left, c.left);
        if (o == target) ans = c;
        solve(o.right, c.right);
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        solve(original, cloned);
        return ans;
    }
}