class Solution {
    public TreeNode construct(int[] preorder, int limit, int[] cnt) {
        if (cnt[0] == preorder.length || preorder[cnt[0]] > limit) return null;
        TreeNode root = new TreeNode(preorder[cnt[0]]);
        cnt[0]++;
        root.left = construct(preorder, root.val, cnt);
        root.right = construct(preorder, limit, cnt);
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, Integer.MAX_VALUE, new int[]{0});
    }
}