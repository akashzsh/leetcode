class Solution {
    private TreeNode construct(int l, int r, int[] nums) {
        if (l == r) return null;
        int idx = l;
        for (int i = l; i < r; i++) if (nums[i] > nums[idx]) idx = i;
        TreeNode root = new TreeNode(nums[idx]);
        root.left = construct(l, idx, nums);
        root.right = construct(idx + 1, r, nums);
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0, nums.length, nums);
    }
}