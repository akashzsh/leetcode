class Solution {
    public TreeNode construct(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inOrder = map.get(postorder[postEnd]);
        int leftSide = inOrder - inStart;
        
        root.left = construct(inorder, inStart, inOrder - 1, postorder, postStart, postStart + leftSide - 1, map);
        
        root.right = construct(inorder, inOrder + 1, inEnd, postorder, postStart + leftSide, postEnd - 1, map);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return construct(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
}