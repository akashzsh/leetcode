class Solution {
    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
    
    void leftBoundary(Node node, ArrayList<Integer> res) {
        while (node != null) {
            if (isLeaf(node)) {
                return;
            }
            res.add(node.data);
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }
    
    void leaves(Node node, ArrayList<Integer> res) {
        if (node == null) {
            return;
        }
        
        leaves(node.left, res);
        
        if (isLeaf(node)) {
            res.add(node.data);
        }
        
        leaves(node.right, res);
    }
    
    void rightBoundary(Node node, ArrayList<Integer> res) {
        Stack<Integer> stk = new Stack<>();
        
        while (node != null) {
            if (isLeaf(node)) {
                break;
            }
            stk.push(node.data);
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        
        while (!stk.isEmpty()) res.add(stk.pop());
    }
    
	ArrayList <Integer> boundary(Node node) {
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    if (!isLeaf(node)) res.add(node.data);
	    
	    leftBoundary(node.left, res);
	    leaves(node, res);
	    rightBoundary(node.right, res);
	    
	    return res;
	}
}