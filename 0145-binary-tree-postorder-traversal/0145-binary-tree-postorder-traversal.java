class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        
        while (cur != null || !stk.isEmpty()) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stk.peek().right;
                if (temp == null) {
                    temp = stk.pop();
                    res.add(temp.val);
                    while (!stk.isEmpty() && temp == stk.peek().right) {
                        temp = stk.pop();
                        res.add(temp.val);
                    }
                } else {
                    cur = temp;
                }
            }
        }
        
        return res;
    }
}

// Recursion

/*
class Solution {
    public void postorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
}
*/