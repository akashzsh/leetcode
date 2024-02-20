class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        
        while (true) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            } else {
                if (stk.isEmpty()) {
                    break;
                }
                cur = stk.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        
        return res;
    }
}

// Recursion

/*
class Solution {
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
}
*/