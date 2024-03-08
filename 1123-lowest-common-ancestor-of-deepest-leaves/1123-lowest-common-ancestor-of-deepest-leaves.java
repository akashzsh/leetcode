class Pair {
    TreeNode node;
    int depth;
    
    Pair (TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    public Pair f(TreeNode root, int d) {
        if (root == null) {
            return new Pair(null, d);
        }
        
        Pair left = f(root.left, d + 1);
        Pair right = f(root.right, d + 1);
        
        if (left.depth == right.depth) {
            return new Pair(root, left.depth);
        }
        
        return left.depth > right.depth ? left : right;
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return f(root, 0).node;
    }
}