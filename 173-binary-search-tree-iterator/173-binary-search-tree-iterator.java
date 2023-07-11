class BSTIterator {
    private Stack<TreeNode> s = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode curr = s.pop();
        if (curr.right != null) pushAll(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    public void pushAll(TreeNode node) {
        while (node != null) {
            s.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */