class Pair {
    TreeNode node;
    int number;
    
    Pair (TreeNode node, int number) {
        this.node = node;
        this.number = number;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        // List<Integer> preorder = new ArrayList<>();
        // List<Integer> postorder = new ArrayList<>();
        
        if (root == null) {
            return inorder;
        }
        
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(root, 1));
        
        while (!stk.isEmpty()) {
            
            Pair cur = stk.pop();
            
            if (cur.number == 1) {    
                // preorder.add(cur.node.val);
                cur.number++;
                stk.push(cur);
                
                if (cur.node.left != null) {
                    stk.push(new Pair(cur.node.left, 1));
                }
                
            } else if (cur.number == 2) {
                inorder.add(cur.node.val);
                cur.number++;
                stk.push(cur);
                
                if (cur.node.right != null) {
                    stk.push(new Pair(cur.node.right, 1));
                }
                
            } else if (cur.number == 3) {
                // postorder.add(cur.node.val);
            }
        }
        
        return inorder;
    }
}