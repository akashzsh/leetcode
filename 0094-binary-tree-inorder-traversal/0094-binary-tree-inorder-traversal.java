// Morris Traversal

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        
        return res;
    }
}


// Iterative

/*
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

*/

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