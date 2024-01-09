class Solution {
    private void dfs(TreeNode root, ArrayList<Integer> t) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            t.add(root.val);
        }
        dfs(root.left, t);
        dfs(root.right, t);
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> t1 = new ArrayList<>();
        ArrayList<Integer> t2 = new ArrayList<>();
        dfs(root1, t1);
        dfs(root2, t2);
        return t1.equals(t2);
    }
}