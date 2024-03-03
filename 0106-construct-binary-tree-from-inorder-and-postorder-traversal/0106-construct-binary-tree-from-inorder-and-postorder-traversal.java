class Solution {
    public TreeNode f(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> map) {
        if (is > ie || ps > pe) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = map.get(postorder[pe]);
        int left = inRoot - is;
        
        root.left = f(inorder, is, inRoot - 1, postorder, ps, ps + left - 1, map);
        root.right = f(inorder, inRoot + 1, ie, postorder, ps + left, pe - 1, map);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return f(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
}