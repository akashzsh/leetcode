class BSTIterator {
    Stack<TreeNode> stk;
    boolean reverse;
    
    BSTIterator(TreeNode root, boolean reverse) {
        stk = new Stack<>();
        this.reverse = reverse;
        pushAllNodes(root);
    }
    
    void pushAllNodes(TreeNode root) {
        while (root != null) {
            stk.push(root);
            if (this.reverse) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
    
    int next() {
        TreeNode cur = stk.pop();
        if (this.reverse) {
            pushAllNodes(cur.left);
        } else {
            pushAllNodes(cur.right);
        }
        
        return cur.val;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator i = new BSTIterator(root, false);
        BSTIterator j = new BSTIterator(root, true);
        
        int low = i.next(), high = j.next();
        
        while (low < high) {
            if (low + high == k) {
                return true;
            }
            
            if (low + high < k) {
                low = i.next();
            } else {
                high = j.next();
            }
        }
        
        return false;
    }
}