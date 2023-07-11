public class BSTIterator {
    private Stack<TreeNode> s = new Stack<>();
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode curr = s.pop();
        if (this.reverse) pushAll(curr.right);
        else pushAll(curr.left);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    public void pushAll(TreeNode node) {
        while (node != null) {
            s.push(node);
            if (this.reverse) node = node.left;
            else node = node.right;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator i = new BSTIterator(root, true);
        BSTIterator j = new BSTIterator(root, false);
        int low = i.next(), high = j.next();
        while (low < high) {
            if (low + high == k) return true;
            if (low + high > k) high = j.next();
            else low = i.next();
        }
        return false;
    }
}